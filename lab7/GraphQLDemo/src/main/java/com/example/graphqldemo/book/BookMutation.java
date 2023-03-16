package com.example.graphqldemo.book;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements GraphQLMutationResolver {

    @Autowired
    private BookService customerService;

    public Book createCustomer(final String customerNumber, final String name, double email, final String phone) {
        return customerService.createCustomer(customerNumber, name, email, phone);
    }
}
