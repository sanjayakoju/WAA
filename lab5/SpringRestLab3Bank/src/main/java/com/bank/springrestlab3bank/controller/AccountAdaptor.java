package com.bank.springrestlab3bank.controller;

import com.bank.springrestlab3bank.model.BankAccount;
import com.bank.springrestlab3bank.model.Transaction;

import java.util.List;

public class AccountAdaptor {

    public static BankAccount getBankAccount(AccountDTO accountDTO) {
        BankAccount bankAccount = new BankAccount();
        if(accountDTO!=null) {
            bankAccount.setAccountNumber(accountDTO.getAccountNumber());
            bankAccount.setAccountHolder(accountDTO.getAccountHolder());
            bankAccount.setBalance(accountDTO.getBalance());
            List<Transaction> transactions = accountDTO.getTransactions();
            bankAccount.setTransactions(transactions);
        }
        return bankAccount;
    }

    public static AccountDTO getAccountDto(BankAccount bankAccount) {
        AccountDTO accountDTO = new AccountDTO();
        if(bankAccount!=null) {
            accountDTO.setAccountNumber(bankAccount.getAccountNumber());
            accountDTO.setAccountHolder(bankAccount.getAccountHolder());
            accountDTO.setBalance(bankAccount.getBalance());
            List<Transaction> transactionDTOS = bankAccount.getTransactions();
            accountDTO.setTransactions(transactionDTOS);
        }
        return accountDTO;
    }
}
