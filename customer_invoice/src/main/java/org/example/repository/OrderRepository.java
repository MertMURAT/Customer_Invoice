package org.example.repository;

import org.example.model.Order;

import java.util.List;

public interface OrderRepository {

    public void save(Order order);
    public List<Order> findAll();
}
