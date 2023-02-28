package com.gettrx.swapi.exception;

public class PeopleNotFoundException extends RuntimeException {
    public PeopleNotFoundException(Integer id) {

        super(String.format("People with Id %d not found", id));
    }
}
