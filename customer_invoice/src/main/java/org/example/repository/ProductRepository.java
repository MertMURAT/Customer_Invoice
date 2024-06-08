package org.example.repository;

import org.example.model.Product;

import java.util.List;

public interface ProductRepository {

    void save(Product product);
    List<Product> findAll();
}
