package com.bank.springrestlab3bank.service;

import com.bank.springrestlab3bank.controller.AccountDTO;

public interface BankService {
    public AccountDTO createBankAccount(AccountDTO accountDTO);
    public AccountDTO depositAmount(int accountNumber, double depositAmount);
    public AccountDTO getAccount(int accountNumber);
    public AccountDTO deleteAccount(int accountNumber);
    public AccountDTO withdraw(int accountNumber, double withDrawAmount);
}
