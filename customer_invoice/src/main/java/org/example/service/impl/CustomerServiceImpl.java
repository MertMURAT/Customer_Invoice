package org.example.service.impl;

import org.example.model.Customer;
import org.example.model.Invoice;
import org.example.repository.CustomerRepository;
import org.example.repository.impl.CustomerRepositoryImpl;
import org.example.service.CustomerService;
import org.example.service.InvoiceService;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public void createCustomer(String name, String surname, String address, String email, String phoneNumber) {
        Customer customer = new Customer(name, surname, address, email, phoneNumber);
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }


    @Override
    public List<Customer> getWithNameChar(String nameChar) {
        return getAll().stream()
                .filter(customer -> customer.getName().contains(nameChar))
                .collect(Collectors.toList());
    }
}
