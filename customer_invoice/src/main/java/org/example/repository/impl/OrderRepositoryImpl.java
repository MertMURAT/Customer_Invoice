package org.example.repository.impl;

import org.example.model.Order;
import org.example.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private final List<Order> orderList = new ArrayList<>();

    @Override
    public void save(Order order) {
        orderList.add(order);
    }

    @Override
    public List<Order> findAll() {
        return orderList;
    }
}
