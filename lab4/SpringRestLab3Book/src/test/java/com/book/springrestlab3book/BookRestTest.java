package com.book.springrestlab3book;

import com.book.springrestlab3book.books.domain.Book;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class BookRestTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testAddBook() {
        loadBook();
        given()
                .when()
                .get("/books/2345")
                .then()
                .statusCode(200)
                .and()
                .body("isbn", equalTo("2345"))
                .body("title", equalTo("The Complete Spring reference"))
                .body("price", equalTo(220.0f))
                .body("author", equalTo("Larry Edision"));
        cleanUpBook();
    }

    @Test
    public void testGetOneBook() {
        // Add the Book to be fetched
        loadBook();

        // Test Getting the Book
        given()
                .when()
                .get("books/2345")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn", equalTo("2345"))
                .body("title", equalTo("The Complete Spring reference"))
                .body("price", equalTo(220.0f))
                .body("author", equalTo("Larry Edision"));
        // Clean up
        cleanUpBook();
    }

    @Test
    public void testUpdateBook() {
        loadBook();
        Book updatedBook = new Book("1234", "The Complete Angular", 120.0, "Alphabet Publication");
        given()
                .contentType("application/json")
                .body(updatedBook)
                .when().put("/books").then()
                .statusCode(200);
        given()
                .when()
                .get("books/1234")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn", equalTo("1234"))
                .body("title", equalTo("The Complete Angular"))
                .body("price", equalTo(120.0f))
                .body("author", equalTo("Alphabet Publication"));
        // Clean up
        cleanUpBook();
    }

    @Test
    public void testDeleteBook() {
        loadBook();
        cleanUpBook();
        given()
                .when()
                .get("books/1234")
                .then()
                .statusCode(404)
                .and()
                .body("errorMessage", equalTo("Book with ISBN 1234 Not Found!"));
    }

    @Test
    public void testGetAllBooks() {
        loadBook();
        given()
                .when()
                .get("books")
                .then()
                .statusCode(200)
                .and()
                .body("isbn", hasItems("1234", "2345"))
                .body("title", hasItems("The Complete Angular", "The Complete Spring reference"))
                .body("price", hasItems(120.0f, 220.0f))
                .body("author", hasItems("Google Publication", "Larry Edision"));
        cleanUpBook();

    }

    @Test
    public void testSearchBook() {
        loadBook();
        given()
                .when()
                .get("books/search?author=Google Publication")
                .then()
                .statusCode(200)
                .and()
                .body("isbn", hasItems("1234"))
                .body("title", hasItems("The Complete Angular"))
                .body("price", hasItems(120.0f))
                .body("author", hasItems("Google Publication"));

        cleanUpBook();
    }

    public void loadBook() {
        Book book1 = new Book("1234", "The Complete Angular", 120.0, "Google Publication");
        Book book2 = new Book("2345", "The Complete Spring reference", 220.0, "Larry Edision");

        given()
                .contentType("application/json")
                .body(book1)
                .when().post("/books").then()
                .statusCode(200);
        given()
                .contentType("application/json")
                .body(book2)
                .when().post("/books").then()
                .statusCode(200);
    }

    public void cleanUpBook() {
        given()
                .when()
                .delete("/books/1234");
        given()
                .when()
                .delete("/books/2345");
    }

}
