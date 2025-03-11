package com.app.justbuy.repository;

import com.app.justbuy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public List<User> findAll();

    Optional<User> findById(long id);

    void deleteById(long id);
    public User save(User user);
}
