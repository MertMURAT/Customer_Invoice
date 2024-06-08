package org.example.repository;

import org.example.model.Company;

import java.util.ArrayList;
import java.util.List;

public interface CompanyRepository {

    public void save(Company company);
    public List<Company> findAll();

}
