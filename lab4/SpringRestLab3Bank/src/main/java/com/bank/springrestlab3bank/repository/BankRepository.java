package com.bank.springrestlab3bank.repository;

import com.bank.springrestlab3bank.enums.TransactionType;
import com.bank.springrestlab3bank.model.BankAccount;
import com.bank.springrestlab3bank.model.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository {

    Map<String, BankAccount> map = new HashMap<>();

    public BankAccount createBankAccount(BankAccount bankAccount) {
        BankAccount account = new BankAccount();
        account.setAccountNumber(bankAccount.getAccountNumber());
        account.setAccountHolder(bankAccount.getAccountHolder());
        account.setTransactions(new ArrayList<>());
        account.setBalance(0.00);
        map.put(bankAccount.getAccountNumber(), account);
        return account;
    }

    public BankAccount depositAmount(String accountNumber, double depositAmount) {
        if(map.containsKey(accountNumber)) {
            BankAccount account = map.get(accountNumber);
            Transaction transaction = new Transaction(depositAmount, TransactionType.DEPOSIT, LocalDateTime.now());
            account.getTransactions().add(transaction);
            account.setBalance(account.getBalance() + depositAmount);
            return account;
        }
        return null;
    }

    public BankAccount getAccount(String accountNumber) {
        if(map.containsKey(accountNumber)) {
            return map.get(accountNumber);
        }
        return null;
    }

    public BankAccount deleteAccount(String accountNumber) {
        if (map.containsKey(accountNumber)) {
            BankAccount account = map.get(accountNumber);
            map.remove(accountNumber);
            return account;
        }
        return null;
    }

    public BankAccount withdraw(String accountNumber, double withDrawAmount) {
        if (map.containsKey(accountNumber)) {
            BankAccount account = map.get(accountNumber);
            if(account.getBalance() >= withDrawAmount) {
                double newBalance = account.getBalance() - withDrawAmount;
                Transaction transaction = new Transaction(withDrawAmount, TransactionType.WITHDRAW, LocalDateTime.now());
                account.getTransactions().add(transaction);
                account.setBalance(newBalance);
                map.put(accountNumber,account);
                return account;
            }
        }
        return null;
    }
}
