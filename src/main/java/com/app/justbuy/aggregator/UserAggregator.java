package com.app.justbuy.aggregator;

import com.app.justbuy.model.User;
import java.util.List;

public interface UserAggregator {

        public List<User> listUsers();

        public User getUser(long id);

        public void removeUser(long id);

        public User editUser(User user);

}
