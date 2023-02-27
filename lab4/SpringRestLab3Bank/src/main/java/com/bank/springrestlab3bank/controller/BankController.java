package com.bank.springrestlab3bank.controller;

import com.bank.springrestlab3bank.exception.CustomError;
import com.bank.springrestlab3bank.model.BankAccount;
import com.bank.springrestlab3bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BankController {

    private BankService bankService;

    @Autowired
    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/banks")
    public ResponseEntity<?> createAccount(@Valid @RequestBody BankAccount account) {
        if(account == null) {
            return new ResponseEntity<>(new CustomError("Account Detail are Empty!"), HttpStatus.NOT_FOUND);
        }
        BankAccount bankAccount = bankService.createBankAccount(account);
        return new ResponseEntity<>(bankAccount, HttpStatus.OK);
    }

    @GetMapping("/banks/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable String accountNumber) {
        BankAccount bankAccount = bankService.getAccount(accountNumber);
        if (bankAccount == null) {
            return new ResponseEntity<>(new CustomError("Account with account number " + accountNumber + " Not Found!"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bankAccount, HttpStatus.OK);
    }

    @PutMapping("/banks/deposit")
    public ResponseEntity<?> deposit(@RequestParam String accountNumber, @RequestParam double amount) {
        BankAccount bankAccount = bankService.depositAmount(accountNumber, amount);
        if (bankAccount != null) {
            return new ResponseEntity<>(bankAccount, HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomError("Deposit amount on account number " + accountNumber + " unsuccessful!"), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/banks/{accountNumber}")
    public ResponseEntity<?> deleteAccount(@PathVariable String accountNumber){
        BankAccount bankAccount = bankService.deleteAccount(accountNumber);
        if (bankAccount != null) {
            return new ResponseEntity<>(bankAccount, HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomError("Account with account number " + accountNumber + " Not Found!"), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/banks/withdraw")
    public ResponseEntity<?> withdraw(@RequestParam String accountNumber, @RequestParam double amount){
        BankAccount bankAccount = bankService.withdraw(accountNumber, amount);
        if (bankAccount == null) {
            return new ResponseEntity<>(new CustomError("Amount Withdraw UnSuccessful!"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bankAccount, HttpStatus.OK);
    }
}
