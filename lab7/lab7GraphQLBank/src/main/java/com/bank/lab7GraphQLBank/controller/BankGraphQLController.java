package com.bank.lab7GraphQLBank.controller;

import com.bank.lab7GraphQLBank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class BankGraphQLController {

    private BankService bankService;

    @Autowired
    public BankGraphQLController(BankService bankService) {
        this.bankService = bankService;
    }

    @MutationMapping
    public Optional<AccountDTO> createAccount(@Valid @Argument AccountDTO account) {
        AccountDTO accountDTO = bankService.createBankAccount(account);
        return Optional.ofNullable(accountDTO);
    }

    @QueryMapping
    public Optional<AccountDTO> getAccount(@Argument int accountNumber) {
        AccountDTO accountDTO = bankService.getAccount(accountNumber);
        return Optional.ofNullable(accountDTO);
    }

    @MutationMapping
    public Optional<AccountDTO> deposit(@Argument int accountNumber, @Argument double amount) {
        AccountDTO accountDTO = bankService.depositAmount(accountNumber, amount);
        System.out.println(accountDTO);
        return Optional.ofNullable(accountDTO);
    }

    @MutationMapping
    public Optional<AccountDTO> deleteAccount(@Argument int accountNumber){
        AccountDTO accountDTO = bankService.deleteAccount(accountNumber);
        return Optional.ofNullable(accountDTO);
    }

    @MutationMapping
    public Optional<AccountDTO> withdraw(@Argument int accountNumber, @Argument double amount){
        AccountDTO accountDTO = bankService.withdraw(accountNumber, amount);
        return Optional.ofNullable(accountDTO);
    }
}
