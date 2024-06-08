package org.example.repository.impl;

import org.example.model.Product;
import org.example.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private final List<Product> productList = new ArrayList<>();

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }
}
