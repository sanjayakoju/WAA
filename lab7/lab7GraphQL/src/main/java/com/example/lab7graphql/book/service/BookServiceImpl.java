package com.example.lab7graphql.book.service;

import com.example.lab7graphql.book.model.Book;
import com.example.lab7graphql.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookByISBN(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    public Book deleteBookByIsbn(String isbn) {
        return bookRepository.deleteByIsbn(isbn);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.update(book);
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchBook(String author) {
        return bookRepository.searchByAuthor(author);
    }

    @Override
    public Book createBook(String isbn, String title, double price, String author) {
        Book book = new Book(isbn,title,price,author);
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBook(int count) {
        return bookRepository.bookByCount(count);
    }

    @Override
    public List<Book> getBookByCount(int count) {
        return bookRepository.bookByCount(count);
    }
}
