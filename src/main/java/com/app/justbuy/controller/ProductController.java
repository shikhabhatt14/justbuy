package com.app.justbuy.controller;

import com.app.justbuy.aggregator.ProductAggregator;
import com.app.justbuy.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductAggregator productAggregator;

    @GetMapping("/products")
    public List<Product> listProducts() {
        return productAggregator.listProducts();
    }

    @PostMapping("/product")
    public Product createProduct(@RequestBody Product product) {
        return productAggregator.editProduct(product);
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable long id) {
        return productAggregator.getProduct(id);
    }

    @DeleteMapping("product/{id}")
    public String deleteProduct(@PathVariable long id) {
        productAggregator.removeProduct(id);
        return "Product deleted";
    }
}
