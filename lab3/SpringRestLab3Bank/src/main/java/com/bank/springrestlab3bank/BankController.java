package com.bank.springrestlab3bank;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankController {

    private AccountDetails accountDetail = new AccountDetails();

    @PostMapping("/banks")
    public ResponseEntity<?> createAccount(@RequestBody BankAccount account) {
        if(account == null) {
            return new ResponseEntity<>(new CustomError("Account Detail are Empty!"), HttpStatus.NOT_FOUND);
        }
        BankAccount bankAccount = accountDetail.createBankAccount(account);
        return new ResponseEntity<>(bankAccount, HttpStatus.OK);
    }

    @GetMapping("/banks/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable String accountNumber) {
        BankAccount bankAccount = accountDetail.getAccount(accountNumber);
        if (bankAccount == null) {
            return new ResponseEntity<>(new CustomError("Account with account number " + accountNumber + " Not Found!"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bankAccount, HttpStatus.OK);
    }

    @PutMapping("/banks/deposit")
    public ResponseEntity<?> deposit(@RequestParam String accountNumber, @RequestParam double amount) {
        BankAccount bankAccount = accountDetail.depositAmount(accountNumber, amount);
        if (bankAccount != null) {
            return new ResponseEntity<>(bankAccount, HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomError("Deposit amount on account number " + accountNumber + " unsuccessful!"), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/banks/{accountNumber}")
    public ResponseEntity<?> deleteAccount(@PathVariable String accountNumber){
        BankAccount bankAccount = accountDetail.deleteAccount(accountNumber);
        if (bankAccount != null) {
            return new ResponseEntity<>(bankAccount, HttpStatus.OK);
        }
        return new ResponseEntity<>(new CustomError("Account with account number " + accountNumber + " Not Found!"), HttpStatus.NOT_FOUND);
    }

    @PutMapping("/banks/withdraw")
    public ResponseEntity<?> withdraw(@RequestParam String accountNumber, @RequestParam double amount){
        BankAccount bankAccount = accountDetail.withdraw(accountNumber, amount);
        if (bankAccount == null) {
            return new ResponseEntity<>(new CustomError("Amount Withdraw UnSuccessful!"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bankAccount, HttpStatus.OK);
    }
}
