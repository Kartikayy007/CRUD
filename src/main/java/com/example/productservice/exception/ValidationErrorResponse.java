package com.example.productservice.exception;

import java.util.Date;
import java.util.Map;

import lombok.Data;

@Data
public class ValidationErrorResponse {
    private Date timestamp;
    private String message;
    private Map<String, String> errors;
    
    public ValidationErrorResponse() {
    }
    
    public ValidationErrorResponse(Date timestamp, String message, Map<String, String> errors) {
        this.timestamp = timestamp;
        this.message = message;
        this.errors = errors;
    }
}
