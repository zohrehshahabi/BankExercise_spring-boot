package com.springboot.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "account")
@Table(name = "T_Account")
public class Account {
    @NotNull
    @Id
    @Column(name = "acc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @Column(name = "acc_sortCode")
    private String sortCode;


    @NotNull
    @Column(name = "acc_no")
    private String accountNumber;

    @Column(name = "acc_isopen")
    private boolean isOpen;

    @Column(name = "acc_balance")
    private Double balance;
    @OneToMany
    private transient List<Transaction> transactions;

   /* @ManyToMany(mappedBy = "accounts", cascade = CascadeType.ALL)
    private List<Person> persons = new ArrayList<>();*/

    @OneToMany(mappedBy = "account",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<AccountPersonHolder> accountPersonHolderList = new ArrayList<>();

    public Account() {
    }

    public Account(AccountType accountType, String accountNumber, boolean isOpen, Double balance) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.isOpen = isOpen;
        this.balance = balance;
    }

    public Account(long id, AccountType accountType, String accountNumber, boolean isOpen,
                   Double balance, List<Transaction> transactions,
                   List<AccountPersonHolder> accountPersonHolderList) {
        this.id = id;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.isOpen = isOpen;
        this.balance = balance;
        this.transactions = transactions;
        this.accountPersonHolderList = accountPersonHolderList;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<AccountPersonHolder> getAccountPersonHolderList() {
        return accountPersonHolderList;
    }

    public void setAccountPersonHolderList(List<AccountPersonHolder> accountPersonHolderList) {
        this.accountPersonHolderList = accountPersonHolderList;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
