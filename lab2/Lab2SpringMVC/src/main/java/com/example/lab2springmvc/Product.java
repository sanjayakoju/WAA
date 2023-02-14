package com.example.lab2springmvc;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Product {


    @NotNull
    @Size(min = 2, max = 5)
    private String productNumber;

    @NotNull
    @Size(min = 2, max = 20)
    private String name;

    private double price;

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
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
}
