package org.example.service;

import org.example.model.Invoice;
import org.example.model.Order;

import java.util.List;
import java.util.Set;

public interface InvoiceService {

    void save(Order order, Double totalPrice);
    List<Invoice> getAll();
    List<Invoice> getAbove(Double amount);
    Double getAmountAverageAbove(Double amount);
    List<String> getNamesBelow(Double amount);
    Double getTotalInJune();
//    public List<String> getSectorBelowPriceForCompany(Double amount);

}
