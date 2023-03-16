package com.bank.lab7GraphQLBank.model;

import com.bank.lab7GraphQLBank.enums.TransactionType;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class Transaction {
    @NotNull
    private double amount;
    @NotNull
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

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", transactionType=" + transactionType +
                ", dateTime=" + dateTime +
                '}';
    }
}
