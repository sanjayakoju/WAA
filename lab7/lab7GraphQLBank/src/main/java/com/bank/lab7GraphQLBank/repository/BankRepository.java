package com.bank.lab7GraphQLBank.repository;

import com.bank.lab7GraphQLBank.model.BankAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends MongoRepository<BankAccount, Integer> {

    BankAccount findBankAccountByAccountNumber(int accountNumber);

}
