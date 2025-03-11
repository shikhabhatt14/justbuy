package com.app.justbuy.repository;

import com.app.justbuy.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

    public List<Product> findAll();

    Optional<Product> findById(long id);

    void deleteById(long id);
    public Product save(Product product);

}
