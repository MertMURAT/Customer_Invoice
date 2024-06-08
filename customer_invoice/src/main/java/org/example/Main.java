package org.example;

import org.example.model.Customer;
import org.example.model.Invoice;
import org.example.model.Product;
import org.example.service.*;
import org.example.service.impl.*;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ProductService productService = new ProductServiceImpl();

        CustomerService customerService = new CustomerServiceImpl();
        CompanyService companyService = new CompanyServiceImpl();
        InvoiceService invoiceService = new InvoiceServiceImpl(customerService, companyService);
        OrderService orderService = new OrderServiceImpl(customerService, invoiceService);

         /*
            MÜŞTERİLERİ OLUŞTUR
         */
        customerService.createCustomer("Mert", "Murat", "Yeni Mah. Yeni Sokak no: 23", "mert@gmail.com", "5334345662");
        customerService.createCustomer("Alican", "Somun", "Atatürk Mah. ilteriş Sokak no: 52", "alican@gmail.com", "5313569875");
        customerService.createCustomer("Cem", "Dırman", "Moğoltay Mah. Çıkmaz Sokak no: 36", "cem@gmail.com", "5384537496");
        customerService.createCustomer("Cabbar", "Karadul", "İlkbahar Mah. Alper Sokak no: 75", "cabbar@gmail.com", "5308694588");

        /*
            ŞİRKETLERİ OLUŞTUR
         */
            companyService.save("Apple", "Technology");
            companyService.save("KebapcıCelal", "Food");
            companyService.save("Koton", "Clothes");

        /*
            ÜRÜNLERİ OLUŞTUR
         */
        productService.save("iPhone", 1200, "Apple");
        productService.save("Kebap", 450, "KebapcıCelal");
        productService.save("Mont", 250, "Koton");

        /*
            ÜRÜNLERİ SEPETE EKLE
         */

        List<Product> basket1 = new ArrayList<>();
        basket1.add(productService.getAll().get(2));

        List<Product> basket2 = new ArrayList<>();
        basket2.add(productService.getAll().get(1));

        List<Product> basket3 = new ArrayList<>();
        basket3.add(productService.getAll().get(0));
        basket3.add(productService.getAll().get(1));

        List<Product> basket4 = new ArrayList<>();
        basket4.add(productService.getAll().get(0));
        basket4.add(productService.getAll().get(1));
        basket4.add(productService.getAll().get(2));

        /*
            SİPARİŞ OLUŞTUR
         */
        orderService.save("mert@gmail.com", basket1);
        orderService.save("cem@gmail.com", basket2);
        orderService.save("alican@gmail.com", basket3);
        orderService.save("cabbar@gmail.com", basket4);

        /*
            FATURA OLUŞTUR
         */

        System.out.println("--------------------------------");
        System.out.println("---------- ÜRÜNLER -------------");
        System.out.println("--------------------------------");
        productService.getAll().forEach(System.out::println);

        System.out.println("\n-----------------------------------");
        System.out.println("---------- SİPARİŞLER -------------");
        System.out.println("-----------------------------------");
        orderService.getAll().forEach(System.out::println);

        System.out.println("\n----------------------------------");
        System.out.println("---------- FATURALAR -------------");
        System.out.println("----------------------------------");
        invoiceService.getAll().forEach(System.out::println);

        System.out.println("\n--------------------------------");
        System.out.println("---------- MÜŞTERİLER ----------");
        System.out.println("--------------------------------");
        customerService.getAll().forEach(System.out::println);


        System.out.println("\n------------------------------------------------");
        System.out.println("-----İçerisinde 'C' harfi olan müşteriler ------");
        System.out.println("------------------------------------------------");
        List<Customer> foundedCustomers = customerService.getWithNameChar("C");
        foundedCustomers.forEach(System.out::println);

        System.out.println("\n---------------------------------------------------------------------");
        System.out.println("----- Haziran ayında kayıt olan müşterilerin fatura toplamları ------");
        System.out.println("---------------------------------------------------------------------");
        double totalInJune = invoiceService.getTotalInJune();
        System.out.println("total : " + +totalInJune);

        System.out.println("\n----------------------------------------------");
        System.out.println("----- Sistemdeki tüm faturaları listele ------");
        System.out.println("----------------------------------------------");
        List<Invoice> allInvoices = invoiceService.getAll();
        allInvoices.forEach(System.out::println);

        System.out.println("\n-------------------------------------------------------------");
        System.out.println("----- Sistemdeki 1500 TL üzerindeki faturaları listele ------");
        System.out.println("-------------------------------------------------------------");
        List<Invoice> aboveAmountList = invoiceService.getAbove(1500.0);
        aboveAmountList.forEach(System.out::println);

        System.out.println("\n-----------------------------------------------------------------");
        System.out.println("----- Sistemdeki 1500 TL üzerindeki faturaların ortalaması ------");
        System.out.println("-----------------------------------------------------------------");
        Double aboveAmountAverage = invoiceService.getAmountAverageAbove(1500.0);
        System.out.println("Sistemdeki 1500 TL üzerindeki faturaların ortalaması : " + aboveAmountAverage);

        System.out.println("\n-----------------------------------------------------------------------------------------");
        System.out.println("----- Sistemdeki 500 TL altındaki faturalara sahip müşterilerin isimlerini listele ------");
        System.out.println("-----------------------------------------------------------------------------------------");
        List<String> namesBelow = invoiceService.getNamesBelow(500.0);
        namesBelow.forEach(System.out::println);

//        System.out.println("\n---------------------------------------------------------------------------------");
//        System.out.println("----- Haziran ayının fatura ortalaması 750 altı olan firmaların sektörleri ------");
//        System.out.println("---------------------------------------------------------------------------------");
//        List<String> sectorBelowPriceForCompany = invoiceService.getSectorBelowPriceForCompany(750.0);
//        sectorBelowPriceForCompany.forEach(System.out::println);

    }
}