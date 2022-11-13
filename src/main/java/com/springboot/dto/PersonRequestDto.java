package com.springboot.dto;

public class PersonRequestDto {
    private String code;

    public PersonRequestDto(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
