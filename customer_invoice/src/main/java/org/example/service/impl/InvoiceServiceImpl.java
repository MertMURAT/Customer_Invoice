package org.example.service.impl;

import org.example.model.Customer;
import org.example.model.Invoice;
import org.example.model.Order;
import org.example.model.Product;
import org.example.repository.InvoiceRepository;
import org.example.repository.impl.InvoiceRepositoryImpl;
import org.example.service.CompanyService;
import org.example.service.CustomerService;
import org.example.service.InvoiceService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


public class InvoiceServiceImpl implements InvoiceService {

    private static final AtomicInteger orderCounter = new AtomicInteger(0);
    private final InvoiceRepository invoiceRepository = new InvoiceRepositoryImpl();
    private final CustomerService customerService;
    private final CompanyService companyService;


    public InvoiceServiceImpl(CustomerService customerService, CompanyService companyService) {
        this.customerService = customerService;
        this.companyService = companyService;
    }

    @Override
    public void save(Order order, Double totalPrice) {

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(generateCode());
        invoice.setOrderId(order.getOrderId());
        invoice.setDate(LocalDateTime.now());
        invoice.setTotalPrice(totalPrice);
        invoice.setProducts(order.getProducts());
        invoice.setCustomerEmail(order.getCustomer().getEmail());

        invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    @Override
    public List<Invoice> getAbove(Double amount) {
        return getAll().stream()
                .filter(invoice -> invoice.getTotalPrice() > amount)
                .toList();
    }

    @Override
    public Double getAmountAverageAbove(Double amount) {
        return getAll().stream()
                .filter(invoice -> invoice.getTotalPrice() > amount)
                .mapToDouble(Invoice::getTotalPrice)
                .average()
                .orElse(0.0);
    }

    @Override
    public List<String> getNamesBelow(Double amount) {
        List<String> nameList = new ArrayList<>();

        List<String> customerEmailList = getAll().stream()
                .filter(invoice -> invoice.getTotalPrice() < amount)
                .map(Invoice::getCustomerEmail)
                .distinct()
                .toList();

        System.out.println("CUSTOMER EMAILS");
        customerEmailList.forEach(System.out::println);

        for (String email : customerEmailList) {
            List<String> list = customerService.getAll().stream()
                    .filter(customer -> customer.getEmail().equals(email))
                    .map(Customer::getName)
                    .toList();
            nameList.add(list.get(0));
        }

        System.out.println("SONUÇ LİSTESİ");

        nameList.forEach(System.out::println);

        return nameList;
    }

    @Override
    public Double getTotalInJune() {

        double total = 0.0;

        List<Customer> foundedCustomers = customerService.getAll().stream()
                .filter(customer -> customer.getCreatedDate().getMonth().equals(Month.JUNE)).toList();

        System.out.println("HAZİRAN MÜŞTERİLER");
        foundedCustomers.forEach(System.out::println);

        for (Customer customer : foundedCustomers) {
            double sum = getAll().stream()
                    .filter(invoice -> invoice.getCustomerEmail().equals(customer.getEmail()))
                    .mapToDouble(Invoice::getTotalPrice)
                    .sum();
            System.out.println(customer.getName().toUpperCase() + " FATURA TOPLAM : " + sum);

            total += sum;
        }

        System.out.println("TOTAL : " + total);

        return total;
    }

//    @Override
//    public List<String> getSectorBelowPriceForCompany(Double amount) {
//
//        List<String> sectorList = new ArrayList<>();
//
//        List<Customer> foundedCustomers = customerService.getAll().stream()
//                .filter(customer -> customer.getCreatedDate().getMonth().equals(Month.JUNE)).toList();
//
//        System.out.println("HAZİRAN MÜŞTERİLER");
//        foundedCustomers.forEach(System.out::println);
//
//        for (Customer customer : foundedCustomers) {
//            sectorList = getAll().stream()
//                    .filter(invoice -> invoice.getCustomerEmail().equals(customer.getEmail()))
//                    .filter(invoice -> invoice.getTotalPrice() < 750)
//                    .map(Invoice::getCustomerEmail)
//                    .distinct()
//                    .toList();
//        }
//        return sectorList;
//    }


    public static String generateCode() {
        return "INV-" + LocalDate.now() + orderCounter.getAndIncrement();
    }
}
