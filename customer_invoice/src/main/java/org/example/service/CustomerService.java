package org.example.service;

import org.example.model.Customer;
import org.example.model.Invoice;
import org.example.repository.CustomerRepository;

import java.time.LocalDate;
import java.util.List;

public interface CustomerService {

    void createCustomer(String name, String surname, String address, String email, String phoneNumber);

    List<Customer> getAll() ;

    List<Customer> getWithNameChar(String nameChar);
}
