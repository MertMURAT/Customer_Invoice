package org.example.service;

import org.example.model.Order;
import org.example.model.Product;

import java.util.List;

public interface OrderService {

    void save(String customerEmail, List<Product> products);
    List<Order> getAll();
}
