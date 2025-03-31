package com.app.justbuy.model;

import java.util.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
public class User {

    private @Id
    @GeneratedValue long id;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String userName;

    private String gstin;   //to be used for seller
    private String email;
    private String phone;
    private String address;

    private Role role;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "is_enabled", nullable = false)
    private boolean isEnabled = true;

    @Column(name = "account_non_locked", nullable = false)
    private boolean accountNonLocked = true;

    @Column(name = "failed_attempt", nullable = false)
    private int failedAttempt = 0;

    @Column(name = "lock_time", nullable = true)
    private LocalDateTime lockTime = null;

    @Column(name = "last_password_change_date", nullable = true)
    private LocalDateTime lastPasswordChangeDate = null;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    public User() {}

    public User(String firstName, String userName, String email, String phone, String address, Role role, String password) {
        this.firstName = firstName;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.role = role;
        this.password = password;
    }

    @PrePersist
    protected void prePersist() {
        this.isEnabled = !Boolean.TRUE.equals(this.isEnabled) || this.isEnabled;
        this.accountNonLocked = true;
        this.failedAttempt = 0;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public int getFailedAttempt() {
        return failedAttempt;
    }

    public void setFailedAttempt(int failedAttempt) {
        this.failedAttempt = failedAttempt;
    }

    public LocalDateTime getLockTime() {
        return lockTime;
    }

    public void setLockTime(LocalDateTime lockTime) {
        this.lockTime = lockTime;
    }

    public LocalDateTime getLastPasswordChangeDate() {
        return lastPasswordChangeDate;
    }

    public void setLastPasswordChangeDate(LocalDateTime lastPasswordChangeDate) {
        this.lastPasswordChangeDate = lastPasswordChangeDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
