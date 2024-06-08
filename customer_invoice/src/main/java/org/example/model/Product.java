package org.example.model;

public class Product {

    private String name;
    private Double price;
    private String companyName;

    public Product(String name, double price, String companyName) {
        this.name = name;
        this.price = price;
        this.companyName = companyName;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}
