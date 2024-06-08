package org.example.service.impl;

import org.example.model.Company;
import org.example.model.Customer;
import org.example.model.Product;
import org.example.repository.ProductRepository;
import org.example.repository.impl.ProductRepositoryImpl;
import org.example.service.CompanyService;
import org.example.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository = new ProductRepositoryImpl();

    @Override
    public void save(String name, double price, String companyName) {
        Product product = new Product(name, price, companyName);
        productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
