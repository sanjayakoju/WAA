package com.example.lab7graphql.book.controller;

import com.example.lab7graphql.book.model.Book;
import com.example.lab7graphql.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class CustomGraphiQL {

    @Autowired
    BookService bookService;

    @GetMapping("custom-graphiql")
    public String graphiql() {
        return "forward:/graphiql/index.html";
    }

    @QueryMapping
    public Collection<Book> getBookByCount(@Argument int count) {
        Collection<Book> books = bookService.getBookByCount(count);
        return books;
    }

    @QueryMapping
    public Collection<Book> getAllBooks() {
        Collection<Book> books = bookService.getAllBook();
        return books;
    }

    @QueryMapping
    public Optional<Book> getBookByISBN(@Argument String isbn) {
        Book book = bookService.getBookByISBN(isbn);
        return Optional.ofNullable(book);
    }

    @QueryMapping
    public Collection<Book> getAllBookByAuthor(@Argument String author) {
        Collection<Book> books = bookService.searchBook(author);
        return books;
    }

    @MutationMapping
    public Book createBook(@Argument String isbn, @Argument String title, @Argument double price, @Argument String author) {
        System.out.println(bookService.createBook(isbn,title,price,author));
       return bookService.createBook(isbn,title,price,author);
    }

    @MutationMapping
    public Book updateBook(@Argument String isbn, @Argument String title, @Argument double price, @Argument String author) {
        Book book = new Book(isbn,title,price,author);
        System.out.println(bookService.updateBook(book));
        return bookService.updateBook(book);
    }

    @MutationMapping
    public Optional<Book> deleteBook(@Argument String isbn) {
        Book deletedBook = bookService.deleteBookByIsbn(isbn);
        return Optional.ofNullable(deletedBook);
    }

}
