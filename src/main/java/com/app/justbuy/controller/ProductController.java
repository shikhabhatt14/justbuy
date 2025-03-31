package com.app.justbuy.controller;

import com.app.justbuy.aggregator.ProductAggregator;
import com.app.justbuy.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/v1")
public class ProductController {

    Logger LOG = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    ProductAggregator productAggregator;

    @GetMapping("/public/products")
    public List<Product> listProducts() {
        LOG.info("listProducts");
        return productAggregator.listProducts();
    }

    @PostMapping("/seller/product")
    public Product createProduct(@RequestBody Product product) {
        LOG.info("createProduct");
        return productAggregator.editProduct(product);
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable long id) {
        return productAggregator.getProduct(id);
    }

    @DeleteMapping("/seller/product/{id}")
    public String deleteProduct(@PathVariable long id) {
        productAggregator.removeProduct(id);
        return "Product deleted";
    }
}
