package com.bank.lab7GraphQLBank.exception;

public class CustomError {

    private String errorMessage;

    public CustomError(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
