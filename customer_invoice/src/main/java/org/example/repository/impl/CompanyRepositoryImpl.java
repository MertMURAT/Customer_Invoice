package org.example.repository.impl;

import org.example.model.Company;
import org.example.repository.CompanyRepository;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepositoryImpl implements CompanyRepository {

    private final List<Company> companyList = new ArrayList<>();

    @Override
    public void save(Company company) {
        companyList.add(company);
    }

    @Override
    public List<Company> findAll() {
        return companyList;
    }
}
