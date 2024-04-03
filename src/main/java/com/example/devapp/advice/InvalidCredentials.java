package com.example.devapp.advice;

public class InvalidCredentials extends RuntimeException{
    public InvalidCredentials(String msg) {
        super(msg);
    }
}
