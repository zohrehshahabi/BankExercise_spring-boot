package com.springboot.dto;

import com.springboot.model.AccountType;

import javax.validation.constraints.NotNull;
//import com.sun.istack.NotNull;

public class AccountRequestDto {
    @NotNull
    private AccountType accountType;

    public AccountRequestDto(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}


