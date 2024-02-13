package com.example.demo.Exception;

public class RecordAlreadyExistsException extends RuntimeException{
    private RecordAlreadyExistsException(String message){
        super(message);
    }
}
