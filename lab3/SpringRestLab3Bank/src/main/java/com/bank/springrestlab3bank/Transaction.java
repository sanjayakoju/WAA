package com.bank.springrestlab3bank;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transaction {

    private double amount;
    private TransactionType transactionType;
    private LocalDateTime dateTime;

    public Transaction() {
    }

    public Transaction(double amount, TransactionType transactionType, LocalDateTime dateTime) {
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
