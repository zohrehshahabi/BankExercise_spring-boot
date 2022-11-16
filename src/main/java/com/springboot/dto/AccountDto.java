package com.springboot.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

public class AccountDto implements Serializable {
    @NotBlank(message = "Account number is mandatory")
    private String accountNumber;

    @NotBlank(message = "Sort code is mandatory")
    private String sortCode;

    public AccountDto() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }
}
