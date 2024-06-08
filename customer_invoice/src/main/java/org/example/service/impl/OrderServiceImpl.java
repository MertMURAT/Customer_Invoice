package org.example.service.impl;

import org.example.model.Customer;
import org.example.model.Invoice;
import org.example.model.Order;
import org.example.model.Product;
import org.example.repository.OrderRepository;
import org.example.repository.impl.OrderRepositoryImpl;
import org.example.service.CompanyService;
import org.example.service.CustomerService;
import org.example.service.InvoiceService;
import org.example.service.OrderService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderServiceImpl implements OrderService {

    private static final AtomicInteger orderCounter = new AtomicInteger(0);

    private static final OrderRepository orderRepository = new OrderRepositoryImpl();
    private final CustomerService customerService;
    private final InvoiceService invoiceService;


    public OrderServiceImpl(CustomerService customerService, InvoiceService invoiceService) {
        this.customerService = customerService;
        this.invoiceService = invoiceService;
    }

    @Override
    public void save(String customerEmail, List<Product> products) {

        Order order = new Order();

        Optional<Customer> foundedCustomer = customerService.getAll()
                .stream()
                .filter(customer -> customer.getEmail().equals(customerEmail))
                .findFirst();


        double totalPrice = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        Optional<Invoice> foundedInvoice = invoiceService.getAll().stream().filter(invoice -> invoice.getCustomerEmail().equals(customerEmail))
                .findFirst();

        foundedInvoice.ifPresent(invoice -> invoice.setOrderId(order.getOrderId()));

        order.setOrderId(generateCode());

        if (foundedCustomer.isPresent()){
            Customer customer = foundedCustomer.get();
            customer.getOrders().add(order.getOrderId());
            order.setCustomer(customer);
        }

        order.setProducts(products);
        order.setDate(LocalDateTime.now());

        invoiceService.save(order, totalPrice);

        Optional<Invoice> createdInvoice = invoiceService.getAll().stream().filter(invoice -> invoice.getOrderId().equals(order.getOrderId()))
                .findFirst();

        createdInvoice.ifPresent(invoice -> order.setInvoiceId(invoice.getInvoiceId()));

        orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public static String generateCode(){
        return "ORD-" + LocalDate.now() + orderCounter.getAndIncrement();
    }
}
