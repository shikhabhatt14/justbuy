package com.app.justbuy.aggregator.impl;

import com.app.justbuy.aggregator.UserAggregator;
import com.app.justbuy.exception.UserNotFoundException;
import com.app.justbuy.model.User;
import com.app.justbuy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Component
public class UserAggregatorImpl implements UserAggregator {

    @Autowired
    UserRepository userRepository;

    public List<User> listUsers() {
        return userRepository.findAll();
    }

    public User getUser(@PathVariable long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException(id);
        return user.get();
    }

    @Override
    public void removeUser(long id) {
        userRepository.deleteById(id);
    }

    public User editUser(User user) {
        return userRepository.findById(user.getId())
                .map(user1 -> {
            user1.setName(user.getName());
            user1.setAddress(user.getAddress());
            user1.setEmail(user.getEmail());
            user1.setPhone(user.getPhone());
            user1.setRole(user.getRole());
            return userRepository.save(user1);
        }).orElseGet(() -> {return userRepository.save(user);});
    }


}
