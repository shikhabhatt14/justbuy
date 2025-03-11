package com.app.justbuy.controller;

import com.app.justbuy.aggregator.UserAggregator;
import com.app.justbuy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserAggregator userAggregator;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userAggregator.listUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id) {
        return userAggregator.getUser(id);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable long id) {
        userAggregator.removeUser(id);
        return "User deleted";
    }

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        return userAggregator.editUser(user);
    }
}
