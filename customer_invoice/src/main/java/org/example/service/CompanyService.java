package org.example.service;

import org.example.model.Company;

import java.util.List;

public interface CompanyService {

    void save(String name, String sector);
    List<Company> getAll();
    List<String> getSectorsWithAverageInvoiceBelowInJune(double amount);
}
