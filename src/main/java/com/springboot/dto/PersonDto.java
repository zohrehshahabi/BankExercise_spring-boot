package com.springboot.dto;

import java.io.Serializable;

public class PersonDto implements Serializable {
    private String name;

    private String customerNumber;

    public PersonDto(String name, String customerNumber) {
        this.name = name;

        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
}
