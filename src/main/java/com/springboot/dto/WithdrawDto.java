package com.springboot.dto;

import javax.validation.constraints.Positive;
import java.util.Objects;

public class WithdrawDto extends AccountDto{

    String sortCode;
    String accountNumber;

    @Positive(message = "Transfer amount must be positive")
    private double amount;

    public WithdrawDto() {
        this.sortCode = super.getSortCode();
        this.accountNumber = super.getAccountNumber();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "WithdrawDto{" +
                "sortCode='" + sortCode + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        WithdrawDto that = (WithdrawDto) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(sortCode, that.sortCode) && Objects.equals(accountNumber, that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sortCode, accountNumber, amount);
    }
}
