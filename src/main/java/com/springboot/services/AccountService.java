package com.springboot.services;

import com.springboot.model.Account;
import com.springboot.model.Person;
import com.springboot.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    PersonService personService;

    public Account saveAccount(Account account) {

        return accountRepository.save(account);
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
    public void checkPerson(Person person){
        /*if (person.equals(person)){

        }*/
    }
}
