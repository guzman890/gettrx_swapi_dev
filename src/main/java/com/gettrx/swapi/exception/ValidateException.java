package com.gettrx.swapi.exception;

public class ValidateException extends RuntimeException {
    public ValidateException(String object) {

        super(String.format("%s in no Valid", object));
    }
}