package org.example.service;

import org.example.model.Customer;
import org.example.model.Product;

import java.util.List;

public interface ProductService {

    void save(String name, double price, String companyName);
    List<Product> getAll();

}
