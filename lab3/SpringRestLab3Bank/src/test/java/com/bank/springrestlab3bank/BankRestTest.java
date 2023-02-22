package com.bank.springrestlab3bank;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class BankRestTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testCreateAccount() {
        loadAccount();
        given()
                .when()
                .get("banks/123456789")
                .then()
                .statusCode(200)
                .and()
                .body("accountNumber", equalTo("123456789"))
                .body("accountHolder", equalTo("Sanjaya Koju"))
                .body("balance", equalTo(0.0f))
                .body("transactions", equalTo(new ArrayList<>()));
        cleanUp();
    }

    @Test
    public void testGetAccount() {
        loadAccount();
        given()
                .when()
                .get("/banks/234567890")
                .then()
                .statusCode(200)
                .and()
                .body("accountNumber", equalTo("234567890"))
                .body("accountHolder", equalTo("Susan Koju"))
                .body("balance", equalTo(0.0f))
                .body("transactions", equalTo(new ArrayList<>()));
        cleanUp();
    }

    @Test
    public void testDepositAccount() {
        loadAccount();

        // Deposit Amount
        given()
                .contentType(ContentType.JSON)
                .queryParams(new HashMap<>() {{
                    put("accountNumber", "234567890");
                    put("amount", 12000);
                }})
                .when()
                .put("/banks/deposit").then()
                .statusCode(200);

        // Verify the account with amount
        given()
                .when()
                .get("/banks/234567890")
                .then()
                .statusCode(200)
                .and()
                .body("accountNumber", equalTo("234567890"))
                .body("accountHolder", equalTo("Susan Koju"))
                .body("balance", equalTo(12000.0f))
                .body("transactions", hasSize(1));
        cleanUp();

    }

    @Test
    public void testWithDrawAccount() {
        loadAccount();
        // Deposit Amount
        given()
                .contentType(ContentType.JSON)
                .queryParams(new HashMap<>() {{
                    put("accountNumber", "234567890");
                    put("amount", 12000);
                }})
                .when()
                .put("/banks/deposit").then()
                .statusCode(200);

        // Withdraw Amount
        given()
                .contentType(ContentType.JSON)
                .queryParams(new HashMap<>() {{
                    put("accountNumber", "234567890");
                    put("amount", 10000);
                }})
                .when()
                .put("/banks/withdraw").then()
                .statusCode(200);

        // Verify the withdraw amount
        given()
                .when()
                .get("/banks/234567890")
                .then()
                .statusCode(200)
                .and()
                .body("accountNumber", equalTo("234567890"))
                .body("accountHolder", equalTo("Susan Koju"))
                .body("balance", equalTo(2000.0f))
                .body("transactions", hasSize(2));

        // Withdraw Amount
        given()
                .contentType(ContentType.JSON)
                .queryParams(new HashMap<>() {{
                    put("accountNumber", "234567890");
                    put("amount", 10000);
                }})
                .when()
                .put("/banks/withdraw").then()
                .statusCode(404)
                .body("errorMessage", equalTo("Amount Withdraw UnSuccessful!"));

        cleanUp();
    }

    @Test
    public void testDeleteAccount() {
        loadAccount();
        cleanUp();
    }

    public void loadAccount() {
        BankAccount bankAccount1 = new BankAccount("123456789", "Sanjaya Koju");
        BankAccount bankAccount2 = new BankAccount("234567890", "Susan Koju");
        bankAccount1.setTransactions(new ArrayList<>());

        given()
                .contentType("application/json")
                .body(bankAccount1)
                .when().post("/banks").then()
                .statusCode(200);
        given()
                .contentType("application/json")
                .body(bankAccount2)
                .when().post("/banks").then()
                .statusCode(200);
    }

    public void cleanUp() {
        given()
                .when()
                .delete("/banks/123456789");
        given()
                .when()
                .delete("/banks/234567890");
    }
}
