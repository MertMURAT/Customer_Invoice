package org.example.repository;

import org.example.model.Invoice;

import java.util.List;

public interface InvoiceRepository {

    public void save(Invoice invoice);
    public List<Invoice> findAll();
}
