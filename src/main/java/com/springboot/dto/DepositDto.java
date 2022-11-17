package com.springboot.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.io.Serializable;

public class DepositDto implements Serializable {
    @NotBlank(message = "Target account no is mandatory")
    private String targetAccountNo;

    @Positive(message = "Transfer amount must be positive")
    private double amount;

    public DepositDto() {
    }

    public String getTargetAccountNo() {
        return targetAccountNo;
    }

    public void setTargetAccountNo(String targetAccountNo) {
        this.targetAccountNo = targetAccountNo;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
