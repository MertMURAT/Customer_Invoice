package org.example.service.impl;

import org.example.model.Company;
import org.example.repository.CompanyRepository;
import org.example.repository.impl.CompanyRepositoryImpl;
import org.example.service.CompanyService;
import org.example.service.InvoiceService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository = new CompanyRepositoryImpl();

    @Override
    public void save(String name, String sector) {
//
//        invoiceService.getAll()
//        Company company = new Company();
//        company.setName(name);
//        company.setSector(sector);
//        company.setInvoices();
    }

    @Override
    public List<Company> getAll() {
        return List.of();
    }

    @Override
    public List<String> getSectorsWithAverageInvoiceBelowInJune(double amount) {
        return List.of();
    }
}
