package org.example.repository.impl;

import org.example.model.Invoice;
import org.example.repository.InvoiceRepository;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepositoryImpl implements InvoiceRepository {

    private final List<Invoice> invoiceList = new ArrayList<>();

    @Override
    public void save(Invoice invoice) {
        invoiceList.add(invoice);
    }

    @Override
    public List<Invoice> findAll() {
        return invoiceList;
    }
}
