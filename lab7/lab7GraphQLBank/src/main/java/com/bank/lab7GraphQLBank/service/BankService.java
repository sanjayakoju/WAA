package com.bank.lab7GraphQLBank.service;

import com.bank.lab7GraphQLBank.controller.AccountDTO;

public interface BankService {
    public AccountDTO createBankAccount(AccountDTO accountDTO);
    public AccountDTO depositAmount(int accountNumber, double depositAmount);
    public AccountDTO getAccount(int accountNumber);
    public AccountDTO deleteAccount(int accountNumber);
    public AccountDTO withdraw(int accountNumber, double withDrawAmount);
}
