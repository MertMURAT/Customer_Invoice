package org.example.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Invoice {

    private String invoiceId;
    private Double totalPrice;
    private LocalDateTime date;
    private List<Product> products;
    private String customerEmail;
    private String orderId;


    public Invoice(String customerEmail, Double totalPrice) {
        this.totalPrice = totalPrice;
        this.date = LocalDateTime.now();
        this.customerEmail = customerEmail;
    }

    public Invoice() {

    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceId='" + invoiceId + '\'' +
                ", totalPrice=" + totalPrice +
                ", date=" + date +
                ", products=" + products +
                ", customerEmail='" + customerEmail + '\'' +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
