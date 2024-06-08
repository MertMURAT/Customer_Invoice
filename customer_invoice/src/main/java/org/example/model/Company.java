package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;
    private String sector;
    private List<String> invoices;

    public Company(String name, String sector, List<Invoice> invoices) {
        this.name = name;
        this.sector = sector;
        this.invoices = new ArrayList<>();
    }

    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public List<String> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<String> orders) {
        this.invoices = orders;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", sector='" + sector + '\'' +
                ", invoices=" + invoices +
                '}';
    }
}
