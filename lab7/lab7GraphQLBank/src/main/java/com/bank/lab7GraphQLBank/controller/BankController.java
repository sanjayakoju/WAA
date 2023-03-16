package com.bank.lab7GraphQLBank.controller;

import com.bank.lab7GraphQLBank.exception.CustomError;
import com.bank.lab7GraphQLBank.service.BankService;
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
    public ResponseEntity<?> createAccount(@Valid @RequestBody AccountDTO account) {
        if(account == null) {
            return new ResponseEntity<>(new CustomError("Account Detail are Empty!"), HttpStatus.NOT_FOUND);
        }
        AccountDTO accountDTO = bankService.createBankAccount(account);
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @GetMapping("/banks/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable int accountNumber) {
        AccountDTO accountDTO = bankService.getAccount(accountNumber);
        if (accountDTO == null) {
            return new ResponseEntity<>(new CustomError("Account with account number " + accountNumber + " Not Found!"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @PutMapping("/banks/deposit")
    public ResponseEntity<?> deposit(@RequestParam int accountNumber, @RequestParam double amount) {
        AccountDTO accountDTO = bankService.depositAmount(accountNumber, amount);
        if (accountDTO != null) {
            return new ResponseEntity<>(accountDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomError("Deposit amount on account number " + accountNumber + " unsuccessful!"), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/banks/{accountNumber}")
    public ResponseEntity<?> deleteAccount(@PathVariable int accountNumber){
        AccountDTO accountDTO = bankService.deleteAccount(accountNumber);
        if (accountDTO != null) {
            return new ResponseEntity<>(accountDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomError("Account with account number " + accountNumber + " Not Found!"), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/banks/withdraw")
    public ResponseEntity<?> withdraw(@RequestParam int accountNumber, @RequestParam double amount){
        AccountDTO accountDTO = bankService.withdraw(accountNumber, amount);
        if (accountDTO == null) {
            return new ResponseEntity<>(new CustomError("Amount Withdraw UnSuccessful!"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }
}
