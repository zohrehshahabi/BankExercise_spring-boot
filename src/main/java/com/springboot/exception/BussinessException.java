package com.springboot.exception;

public class BussinessException extends RuntimeException {
    public BussinessException(String message) {
        super(message);
    }
}
