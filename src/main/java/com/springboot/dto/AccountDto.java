package com.springboot.dto;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDto that = (AccountDto) o;
        return Objects.equals(accountNumber, that.accountNumber) && Objects.equals(sortCode, that.sortCode);
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "accountNumber='" + accountNumber + '\'' +
                ", sortCode='" + sortCode + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, sortCode);
    }

}
