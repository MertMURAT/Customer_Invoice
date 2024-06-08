package org.example.repository.impl;

import org.example.model.Customer;
import org.example.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepositoryImpl implements CustomerRepository {

    private final List<Customer> customerList = new ArrayList<>();

    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public Optional<Customer> findByName(String name) {
        return customerList.stream()
                .filter(customer -> customer.getName().equals(name))
                .findFirst();
    }
}
