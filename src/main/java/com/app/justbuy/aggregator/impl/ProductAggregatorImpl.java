package com.app.justbuy.aggregator.impl;

import com.app.justbuy.aggregator.ProductAggregator;
import com.app.justbuy.exception.ProductNotFoundException;
import com.app.justbuy.model.DatabaseSequence;
import com.app.justbuy.model.Product;
import com.app.justbuy.repository.ProductRepository;
import com.app.justbuy.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class ProductAggregatorImpl implements ProductAggregator {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SequenceGeneratorService sequenceGeneratorService;

    @Override
    public List<Product> listProducts() {

        return productRepository.findAll();
    }

    @Override
    public Product getProduct(@PathVariable long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty())
            throw new ProductNotFoundException(id);
        return product.get();
    }

    @Override
    public void removeProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product editProduct(Product product) {
        if(Objects.isNull(product.getId()))
            product.setId(0L);
        return productRepository.findById(product.getId())
                .map(product1 -> {
                    product1.setName(product.getName());
                    product1.setPrice(product.getPrice());
                    product1.setCategory(product.getCategory());
                    return productRepository.save(product1);
                })
                .orElseGet(() -> {
                    product.setId(sequenceGeneratorService.generateSequence(Product.SEQUENCE_NAME));
                    return productRepository.save(product);
                });
    }
}