package com.springboot.services;

import com.springboot.dto.TransactionDto;
import com.springboot.model.Account;
import com.springboot.model.Action;
import com.springboot.model.Transaction;
import com.springboot.repository.AccountRepository;

import com.springboot.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;


    public boolean makeTransfer(TransactionDto transactionDto) {
        String sourceSortCode = transactionDto.getSourceAccount().getSortCode();
        String sourceAccountNumber = transactionDto.getSourceAccount().getAccountNumber();
        Optional<Account> sourceAccount = accountRepository
                .findBySortCodeAndAccountNumber(sourceSortCode, sourceAccountNumber);
        String targetSortCode = transactionDto.getTargetAccount().getSortCode();
        String targetAccountNumber = transactionDto.getTargetAccount().getAccountNumber();
        Optional<Account> targetAccount = accountRepository
                .findBySortCodeAndAccountNumber(targetSortCode, targetAccountNumber);

        if (sourceAccount.isPresent() && targetAccount.isPresent()) {
            if (isAmountAvailable(transactionDto.getAmount(), sourceAccount.get().getBalance())) {
                var transaction = new Transaction();
                transaction.setAmount(transactionDto.getAmount());
                transaction.setSourceAccountId(sourceAccount.get().getId());
                transaction.setTargetAccountId(targetAccount.get().getId());
                transaction.setTargetOwnerName(transaction.getTargetOwnerName());
                transaction.setInitiationDate(LocalDateTime.now());
                transaction.setCompletionDate(LocalDateTime.now());
                updateAccountBalance(sourceAccount.get(), transactionDto.getAmount(), Action.WITHDRAW);
                transactionRepository.save(transaction);

                return true;
            }
        }
        return false;
    }

    public void updateAccountBalance(Account account, double amount, Action action) {
        if (action == Action.WITHDRAW) {
            account.setBalance((account.getBalance() - amount));
        } else if (action == Action.DEPOSIT) {
            account.setBalance((account.getBalance() + amount));
        }
        accountRepository.save(account);
    }


    public boolean isAmountAvailable(double amount, double accountBalance) {
        return (accountBalance - amount) > 0;
    }

    public Iterable<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }
    public Transaction createTransaction(Transaction transaction){
       return transactionRepository.save(transaction);
    }
}