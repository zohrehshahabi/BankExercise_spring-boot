package com.springboot.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.io.Serializable;

public class TransactionDto implements Serializable {
    AccountDto sourceAccount;

    AccountDto targetAccount;

    @Positive(message = "Transfer amount must be positive")
    @Min(value = 1, message = "Amount must be larger than 1")
    private double amount;

    public TransactionDto() {
    }

    public AccountDto getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(AccountDto sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public AccountDto getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(AccountDto targetAccount) {
        this.targetAccount = targetAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
