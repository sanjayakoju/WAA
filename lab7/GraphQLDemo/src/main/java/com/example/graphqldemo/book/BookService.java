package com.example.graphqldemo.book;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    Map<String, Book> customers = new HashMap<>();

    public List<Book> getAllCustomers(int count) {
        List<Book> customerList  = customers.values().stream().collect(Collectors.toList());
        return customerList.subList(0,count);
    }

    public Optional<Book> getCustomer(int customerNumber) {
        return  Optional.of(customers.get(customerNumber));
    }

    public Book createCustomer(String customerNumber, String name, double email, String phone) {
        Book customer = new Book(customerNumber, name, email, phone);
        customers.put(customerNumber, customer);
        return customer;
    }
}
