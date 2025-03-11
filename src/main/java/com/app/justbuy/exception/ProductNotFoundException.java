package com.app.justbuy.exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(long id) {
        super("Could not find product with id "+id);
    }
}
