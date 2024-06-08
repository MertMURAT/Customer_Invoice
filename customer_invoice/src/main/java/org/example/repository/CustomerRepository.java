package org.example.repository;

import org.example.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    public void save(Customer customer);
    public List<Customer> findAll();
    public Optional<Customer> findByName(String name);
}
