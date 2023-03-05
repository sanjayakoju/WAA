package com.bank.springrestlab3bank.repository;

import com.bank.springrestlab3bank.model.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends MongoRepository<BankAccount, Integer> {

    BankAccount findBankAccountByAccountNumber(int accountNumber);

}
