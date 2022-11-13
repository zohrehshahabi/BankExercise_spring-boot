package com.springboot.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "T_Account")
public class Account {
    @NotNull
    @Id
    @Column(name = "acc_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    private AccountType accountType;

    @NotNull
    @Column(name = "acc_no")
    private String accountNumber;

    @Column(name = "acc_isopen")
    private boolean isOpen;

    @Column(name = "acc_balance")
    private Double balance;

   /* @ManyToMany(mappedBy = "accounts", cascade = CascadeType.ALL)
    private List<Person> persons = new ArrayList<>();*/

    @OneToMany(mappedBy = "account",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<AccountPerson> accountPersonList = new ArrayList<>();

    public Account() {
    }

    public Account(AccountType accountType, String accountNumber, boolean isOpen, Double balance) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.isOpen = isOpen;
        this.balance = balance;
    }

    public List<AccountPerson> getAccountPersonList() {
        return accountPersonList;
    }

    public void setAccountPersonList(List<AccountPerson> accountPersonList) {
        this.accountPersonList = accountPersonList;
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
