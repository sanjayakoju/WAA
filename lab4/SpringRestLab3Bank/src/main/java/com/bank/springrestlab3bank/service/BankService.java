package com.bank.springrestlab3bank.service;

import com.bank.springrestlab3bank.model.BankAccount;

public interface BankService {
    public BankAccount createBankAccount(BankAccount bankAccount);
    public BankAccount depositAmount(String accountNumber, double depositAmount);
    public BankAccount getAccount(String accountNumber);
    public BankAccount deleteAccount(String accountNumber);
    public BankAccount withdraw(String accountNumber, double withDrawAmount);
}
