package com.bank.springrestlab3bank.controller;

import com.bank.springrestlab3bank.enums.TransactionType;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TransactionDTO {

    @NotNull
    private double amount;
    @NotNull
    private TransactionType transactionType;
    private LocalDateTime dateTime;

    public TransactionDTO() {
    }

    public TransactionDTO(double amount, TransactionType transactionType, LocalDateTime dateTime) {
        this.amount = amount;
        this.transactionType = transactionType;
        this.dateTime = dateTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
