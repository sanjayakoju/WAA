package com.bank.lab7GraphQLBank.service;

import com.bank.lab7GraphQLBank.controller.AccountAdaptor;
import com.bank.lab7GraphQLBank.controller.AccountDTO;
import com.bank.lab7GraphQLBank.enums.TransactionType;
import com.bank.lab7GraphQLBank.model.BankAccount;
import com.bank.lab7GraphQLBank.model.Transaction;
import com.bank.lab7GraphQLBank.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    private BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public AccountDTO createBankAccount(AccountDTO accountDTO) {
        BankAccount bankAccount = AccountAdaptor.getBankAccount(accountDTO);
        List<Transaction> transactions = new ArrayList<>();
        if(accountDTO.getTransactions()!=null) {
            Transaction transaction = new Transaction(accountDTO.getBalance(), TransactionType.DEPOSIT, LocalDateTime.now());
            accountDTO.getTransactions().add(transaction);
        }
        bankAccount.setTransactions(transactions);
        BankAccount returnAccount = bankRepository.save(bankAccount);
        AccountDTO saveAccountDto = AccountAdaptor.getAccountDto(returnAccount);
        return saveAccountDto;
    }

    @Override
    public AccountDTO getAccount(int accountNumber) {
        BankAccount bankAccount = bankRepository.findBankAccountByAccountNumber(accountNumber);
        if (bankAccount == null) {
            return null;
        }
        AccountDTO accountDTO = AccountAdaptor.getAccountDto(bankAccount);
        return accountDTO;
    }

    @Override
    public AccountDTO deleteAccount(int accountNumber) {
        BankAccount bankAccount = bankRepository.findBankAccountByAccountNumber(accountNumber);
        if (bankAccount == null) {
            return null;
        }
        bankRepository.delete(bankAccount);
        return AccountAdaptor.getAccountDto(bankAccount);
    }

    @Override
    public AccountDTO depositAmount(int accountNumber, double depositAmount) {
        BankAccount account = bankRepository.findBankAccountByAccountNumber(accountNumber);
        if(account!=null) {
            double newBalance = account.getBalance() + depositAmount;
            Transaction transaction = new Transaction(depositAmount, TransactionType.DEPOSIT, LocalDateTime.now());
            if(account.getTransactions()!=null) {
                account.getTransactions().add(transaction);
            } else {
                List<Transaction> transactions = new ArrayList<>();
                transactions.add(transaction);
                account.setTransactions(transactions);
            }
            account.setBalance(newBalance);
            BankAccount saveAccount = bankRepository.save(account);
            AccountDTO accountDTO = AccountAdaptor.getAccountDto(saveAccount);
            return accountDTO;
        }
        return null;
    }

    @Override
    public AccountDTO withdraw(int accountNumber, double withDrawAmount) {
        BankAccount account = bankRepository.findBankAccountByAccountNumber(accountNumber);
        if(account!=null) {
            if(account.getBalance() < withDrawAmount) return null;
            double newBalance = account.getBalance() - withDrawAmount;
            Transaction transaction = new Transaction(withDrawAmount, TransactionType.WITHDRAW, LocalDateTime.now());
            if(account.getTransactions()!=null) {
                account.getTransactions().add(transaction);
            } else {
                List<Transaction> transactions = new ArrayList<>();
                transactions.add(transaction);
                account.setTransactions(transactions);
            }
            account.setBalance(newBalance);
            BankAccount saveAccount = bankRepository.save(account);
            AccountDTO accountDTO = AccountAdaptor.getAccountDto(saveAccount);
            return accountDTO;
        }
        return null;
    }
}
