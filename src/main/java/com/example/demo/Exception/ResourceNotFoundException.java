package com.example.demo.Exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
