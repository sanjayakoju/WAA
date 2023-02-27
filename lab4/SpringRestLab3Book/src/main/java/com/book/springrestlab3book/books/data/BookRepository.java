package com.book.springrestlab3book.books.data;

import com.book.springrestlab3book.books.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {

    Map<String, Book> bookMap = new HashMap<>();

    public Book save(Book book) {
        bookMap.put(book.getIsbn(), book);
        return bookMap.get(book.getIsbn());
    }

    public Book findByIsbn(String isbn) {
        return bookMap.get(isbn);
    }

    public Book deleteByIsbn(String isbn) {
        Book book = bookMap.get(isbn);
        bookMap.remove(isbn);
        return book;
    }

    public Book update(Book book) {
        return bookMap.put(book.getIsbn(), book);
    }

    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        for (Map.Entry<String, Book> entry : bookMap.entrySet()) {
            Book book = entry.getValue();
            bookList.add(book);
        }
        return bookList;
    }

    public List<Book> searchByAuthor(String author) {
        List<Book> bookList = new ArrayList<>();
        for (Map.Entry<String, Book> entry : bookMap.entrySet()) {
            Book book = entry.getValue();
            if (author.equals(book.getAuthor()))
                bookList.add(book);
        }
        return bookList;
    }
}
