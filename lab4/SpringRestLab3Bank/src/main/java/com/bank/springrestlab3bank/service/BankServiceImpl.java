package com.bank.springrestlab3bank.service;

import com.bank.springrestlab3bank.model.BankAccount;
import com.bank.springrestlab3bank.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    private BankRepository bankRepository;

    @Autowired
    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public BankAccount createBankAccount(BankAccount bankAccount) {
        return bankRepository.createBankAccount(bankAccount);
    }

    @Override
    public BankAccount depositAmount(String accountNumber, double depositAmount) {
        return bankRepository.depositAmount(accountNumber, depositAmount);
    }

    @Override
    public BankAccount getAccount(String accountNumber) {
        return bankRepository.getAccount(accountNumber);
    }

    @Override
    public BankAccount deleteAccount(String accountNumber) {
        return bankRepository.deleteAccount(accountNumber);
    }

    @Override
    public BankAccount withdraw(String accountNumber, double withDrawAmount) {
        return bankRepository.withdraw(accountNumber, withDrawAmount);
    }
}
