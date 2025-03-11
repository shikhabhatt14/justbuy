package com.app.justbuy.aggregator;

import com.app.justbuy.model.Product;

import java.util.List;

public interface ProductAggregator {

    public List<Product> listProducts();

    public Product getProduct(long id);

    public void removeProduct(long id);

    public Product editProduct(Product product);

}
