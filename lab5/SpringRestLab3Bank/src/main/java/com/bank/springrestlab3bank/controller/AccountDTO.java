package com.bank.springrestlab3bank.controller;

import com.bank.springrestlab3bank.model.Transaction;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class AccountDTO {

    private int accountNumber;
    @NotNull
    @NotEmpty(message = "Account Holder Name Can not be Empty!")
    private String accountHolder;
    private double balance;

    private List<Transaction> transactions;

    public AccountDTO() {
    }

    public AccountDTO(int accountNumber, String accountHolder, double balance, List<Transaction> transactions) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.transactions = transactions;
    }

    public AccountDTO(int accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
