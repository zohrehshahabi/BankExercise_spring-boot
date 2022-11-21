package com.springboot;

import com.springboot.model.*;
import com.springboot.services.AccountService;
import com.springboot.services.PersonService;
import com.springboot.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication


public class Application implements CommandLineRunner {


    @Autowired
    private PersonService personService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private AccountService accountService;

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//transactions
        Transaction transaction1 = transactionService.createTransaction(new Transaction(123432,
                12233,
                "reza akbari", 120000, LocalDateTime.now(), LocalDateTime.now()));
        Transaction transaction2 = transactionService.createTransaction(new Transaction(123433,
                12235,
                "zohreh shahabi", 130000, LocalDateTime.now(), LocalDateTime.now()));
        Transaction transaction3 = transactionService.createTransaction(new Transaction(123434,
                12236,
                "mina safavi", 140000, LocalDateTime.now(), LocalDateTime.now()));

        //accouns
        List<Transaction> transactionList1 = new ArrayList<>();
        transactionList1.add(transaction1);
        Account account1 = accountService.saveAccount(new Account(AccountType.CURRENTACCOUNT,
                "123434", "0123451", true, 19876600.0, transactionList1));
        List<Transaction> transactionList2 = new ArrayList<>();
        transactionList1.add(transaction2);

        Account account2 = accountService.saveAccount(new Account(AccountType.CURRENTACCOUNT,
                "123435", "0123453", true, 18896600.0, transactionList2));

        List<Transaction> transactionList3 = new ArrayList<>();
        transactionList1.add(transaction3);

        Account account3 = accountService.saveAccount(new Account(AccountType.LOANACCOUNT,
                "123436", "0123454", true, 188976600.0, transactionList3));
        //person
        Person person1 = personService.savePerson(new Person("ali bakhtiari", "1239000",
                "1234230"));
        Person person2 = personService.savePerson(new Person("elham eftekhari", "1239111",
                "1234231"));
        Person person3 = personService.savePerson(new Person("sina vahedi", "1239222",
                "1234232"));
        //accountPersonHolder
        AccountPersonHolder accountPersonHolder1 = new AccountPersonHolder(account1, person1);
        AccountPersonHolder accountPersonHolder2 = new AccountPersonHolder(account2, person2);
        AccountPersonHolder accountPersonHolder3 = new AccountPersonHolder(account3, person3);
        List<AccountPersonHolder> accountPersonHolderList1=new ArrayList<>();
        accountPersonHolderList1.add(accountPersonHolder1);

        List<AccountPersonHolder> accountPersonHolderList2=new ArrayList<>();
        accountPersonHolderList2.add(accountPersonHolder2);

        List<AccountPersonHolder> accountPersonHolderList3=new ArrayList<>();
        accountPersonHolderList2.add(accountPersonHolder3);

        person1.setAccountPersonList(accountPersonHolderList1);
        person2.setAccountPersonList(accountPersonHolderList2);
        person3.setAccountPersonList(accountPersonHolderList3);
        account1.setAccountPersonHolderList(accountPersonHolderList1);
        account2.setAccountPersonHolderList(accountPersonHolderList2);
        account3.setAccountPersonHolderList(accountPersonHolderList3);




    }
}

