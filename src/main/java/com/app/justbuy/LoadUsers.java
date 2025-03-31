package com.app.justbuy;

import com.app.justbuy.model.Role;
import com.app.justbuy.model.User;
import com.app.justbuy.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadUsers {

    private static final Logger log = LoggerFactory.getLogger(LoadUsers.class);

    @Bean
    CommandLineRunner initUserDatabase(UserRepository repository) {
        //CommandLineRunner initDatabase(UserRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new User("abc", "abc", "abc@gmail.com", "9999991234", "Khatima", Role.BUYER, "password")));
            log.info("Preloading " + repository.save(new User("def", "def", "def@gmail.com", "9999912345", "Khatima", Role.SELLER, "password")));
            log.info("Preloading " + repository.save(new User("admin", "admin", "admin@gmail.com", "9999912345", "Khatima", Role.SELLER, "$2a$12$fIUZSHbSNZkio61AFUHj5.g85GqWPmyIVkI2qXcbaQ7NXHikzCFlK"))); //password=admin
        };
    }
}
