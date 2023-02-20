package com.book.springrestlab3book;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    Map<String, Book> bookMap = new HashMap<>();

    public BookController() {
        Book book1 = new Book("1234", "The Complete Java", 120, "James Gosling");
        Book book2 = new Book("2345", "The Complete Spring reference", 220, "Larry Edision");
        bookMap.put(book1.getIsbn(), book1);
        bookMap.put(book2.getIsbn(), book2);
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        if(book!=null) {
            bookMap.put(book.getIsbn(), book);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn) {
        Book book;
        if(bookMap.containsKey(isbn)) {
            return new ResponseEntity<>(bookMap.get(isbn), HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomError("Book with ISBN "+isbn+" Not Found!"), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/books")
    public ResponseEntity<?> updateBook(@RequestBody Book book) {
        if(bookMap.containsKey(book.getIsbn())) {
            bookMap.put(book.getIsbn(), book);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomError("Book Not Found!"), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn) {
        if(bookMap.containsKey(isbn)) {
            bookMap.remove(isbn);
            return new ResponseEntity<>("Book with ISBN : "+isbn+" Delete Successfully!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new CustomError("Book with ISBN "+isbn+" Not Found!"), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        if(!bookMap.isEmpty())
            return new ResponseEntity<>(bookMap.values(), HttpStatus.OK);
        return new ResponseEntity<>(new CustomError("Books is Empty"), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/books/search")
    public ResponseEntity<?> searchBooks(@RequestParam("author") String author) {
        List<Book> bookList = BookHelper.searchBook(author, bookMap);
        if(bookList.size()!=0)
            return new ResponseEntity<>(bookList, HttpStatus.OK);
        return new ResponseEntity<>(new CustomError("Book Not Found!"), HttpStatus.NOT_FOUND);
    }
}
