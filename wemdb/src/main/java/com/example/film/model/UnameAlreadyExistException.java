package com.example.film.model;

public class UnameAlreadyExistException extends Exception{
    public UnameAlreadyExistException() {
        super();
    }


    public UnameAlreadyExistException(String message) {
        super(message);
    }


    public UnameAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
