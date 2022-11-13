package com.springboot.exception;

import java.time.LocalDateTime;

public class ResponseError {
    private String message;

    private LocalDateTime localDateTime;

    private String applicationName;

    public ResponseError(String message, LocalDateTime localDateTime, String applicationName) {
        this.message = message;
        this.localDateTime = localDateTime;
        this.applicationName = applicationName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }
}

