package com.springboot.dto;

import javax.validation.constraints.NotBlank;

public class CreateAccountDto {
    @NotBlank(message = "Owner name is mandatory")
    private String ownerName;

    public CreateAccountDto() {
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
