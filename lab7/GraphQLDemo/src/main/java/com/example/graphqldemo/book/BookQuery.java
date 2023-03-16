package com.example.graphqldemo.book;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookQuery implements GraphQLQueryResolver {

    @Autowired
    private BookService customerService;

    public List<Book> getCustomers(final int count) {
        return customerService.getAllCustomers(count);
    }

    public Optional<Book> getCustomer(final int customerNumber) {
        return customerService.getCustomer(customerNumber);
    }
}
