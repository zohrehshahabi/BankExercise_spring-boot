package com.springboot.services;

import com.springboot.model.Account;
import com.springboot.model.Person;
import com.springboot.repository.AccountRepository;
import com.springboot.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public Account createAccount( String ownerName) {

        Account newAccount = new Account();
        return accountRepository.save(newAccount);
    }
    public Account saveAccount(Account account) {

        return accountRepository.save(account);
    }
    public Account getAccount(String sortCode, String accountNumber) {
        Optional<Account> account = accountRepository
                        .findBySortCodeAndAccountNumber(sortCode, accountNumber);

               account.ifPresent(value ->
                       value.setTransactions(transactionRepository
                                .findBySourceAccountIdOrderByInitiationDate(value.getId())));

               return account.orElse(null);

    }
    public Account getAccount(String accountNumber) {
        Optional<Account> account = accountRepository
                .findByAccountNumber(accountNumber);

        return account.orElse(null);
    }

    public void deleteAccount(Account account) {
        accountRepository.delete(account);
    }

    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

    public Iterable<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    }

