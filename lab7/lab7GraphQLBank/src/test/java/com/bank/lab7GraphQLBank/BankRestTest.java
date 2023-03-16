package com.bank.lab7GraphQLBank;

import com.bank.lab7GraphQLBank.controller.AccountDTO;
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
                .get("banks/1234")
                .then()
                .statusCode(200)
                .and()
                .body("accountNumber", equalTo(1234))
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
                .get("/banks/2345")
                .then()
                .statusCode(200)
                .and()
                .body("accountNumber", equalTo(2345))
                .body("accountHolder", equalTo("Susan Koju"))
                .body("balance", equalTo(0.0f))
                .body("transactions", equalTo(null));
        cleanUp();
    }

    @Test
    public void testDepositAccount() {
        loadAccount();

        // Deposit Amount
        given()
                .contentType(ContentType.JSON)
                .queryParams(new HashMap<>() {{
                    put("accountNumber", 2345);
                    put("amount", 12000);
                }})
                .when()
                .put("/banks/deposit").then()
                .statusCode(200);

        // Verify the account with amount
        given()
                .when()
                .get("/banks/2345")
                .then()
                .statusCode(200)
                .and()
                .body("accountNumber", equalTo(2345))
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
                    put("accountNumber", 2345);
                    put("amount", 12000);
                }})
                .when()
                .put("/banks/deposit").then()
                .statusCode(200);

        // Withdraw Amount
        given()
                .contentType(ContentType.JSON)
                .queryParams(new HashMap<>() {{
                    put("accountNumber", 2345);
                    put("amount", 10000);
                }})
                .when()
                .put("/banks/withdraw").then()
                .statusCode(200);

        // Verify the withdraw amount
        given()
                .when()
                .get("/banks/2345")
                .then()
                .statusCode(200)
                .and()
                .body("accountNumber", equalTo(2345))
                .body("accountHolder", equalTo("Susan Koju"))
                .body("balance", equalTo(2000.0f))
                .body("transactions", hasSize(2));

        // Withdraw Amount
        given()
                .contentType(ContentType.JSON)
                .queryParams(new HashMap<>() {{
                    put("accountNumber", 2345);
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
        AccountDTO accountDTO1 = new AccountDTO(1234, "Sanjaya Koju");
        AccountDTO accountDTO2 = new AccountDTO(2345, "Susan Koju");
        accountDTO1.setTransactions(new ArrayList<>());

        given()
                .contentType("application/json")
                .body(accountDTO1)
                .when().post("/banks").then()
                .statusCode(200);
        given()
                .contentType("application/json")
                .body(accountDTO2)
                .when().post("/banks").then()
                .statusCode(200);
    }

    public void cleanUp() {
        given()
                .when()
                .delete("/banks/1234");
        given()
                .when()
                .delete("/banks/2345");
    }
}
