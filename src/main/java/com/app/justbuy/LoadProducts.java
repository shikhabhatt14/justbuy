package com.app.justbuy;

import com.app.justbuy.model.Category;
import com.app.justbuy.model.Product;
import com.app.justbuy.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadProducts {

   /* private static final Logger log = LoggerFactory.getLogger(LoadProducts.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Product("Speaker", 4000, Category.ELECTRONICS)));
            log.info("Preloading " + repository.save(new Product("Pencil", 30, Category.STATIONARY)));
        };
    }*/
}
