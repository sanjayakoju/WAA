package com.book.springrestlab3book.books.service;

import com.book.springrestlab3book.books.data.BookRepository;
import com.book.springrestlab3book.books.domain.Book;
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
}
