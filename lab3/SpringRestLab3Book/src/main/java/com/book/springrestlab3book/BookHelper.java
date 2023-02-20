package com.book.springrestlab3book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookHelper {

    public static List<Book> searchBook(String author, Map<String,Book> bookMap) {
        List<Book> bookList = new ArrayList<>();
        for(Map.Entry<String, Book> entry: bookMap.entrySet()) {
            Book book = entry.getValue();
            if(author.equals(book.getAuthor()))
                bookList.add(book);
        }
        return bookList;
    }
}
