package com.book.springrestlab3book.books.web;

import com.book.springrestlab3book.books.domain.Book;
import com.book.springrestlab3book.books.service.BookService;
import com.book.springrestlab3book.books.exception.CustomError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@Valid @RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.OK);
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn) {
        Book book = bookService.getBookByISBN(isbn);
        if(book!=null) {
            return new ResponseEntity<>(bookService.getBookByISBN(isbn), HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomError("Book with ISBN "+isbn+" Not Found!"), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/books")
    public ResponseEntity<?> updateBook(@Valid @RequestBody Book book) {
        Book updatedBook = bookService.updateBook(book);
        if(updatedBook!=null) {
            return new ResponseEntity<>(bookService.updateBook(book), HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomError("Book Not Found!"), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn) {
        Book deletedBook = bookService.deleteBookByIsbn(isbn);
        if(deletedBook!=null) {
            return new ResponseEntity<>(deletedBook, HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomError("Book with ISBN "+isbn+" Not Found!"), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        List<Book> bookList = bookService.getAllBook();
        if(bookList.size()!=0)
            return new ResponseEntity<>(bookList, HttpStatus.OK);
        return new ResponseEntity<>(new CustomError("Books is Empty"), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/books/search")
    public ResponseEntity<?> searchBooks(@RequestParam("author") String author) {
        List<Book> bookList = bookService.searchBook(author);
        if(bookList.size()!=0)
            return new ResponseEntity<>(bookList, HttpStatus.OK);
        return new ResponseEntity<>(new CustomError("Book Not Found!"), HttpStatus.NOT_FOUND);
    }
}
