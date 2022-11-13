package com.springboot.dto;

import java.io.Serializable;

public class AccountDto implements Serializable {

    private String accountNumber;
    private boolean isOpen;
    private Double balance;

    public AccountDto(String accountNumber, boolean isOpen, Double balance) {
        this.accountNumber = accountNumber;
        this.isOpen = isOpen;
        this.balance = balance;
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
