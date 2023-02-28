package com.gettrx.swapi.exception;

public class PageNotFoundException extends RuntimeException {
    public PageNotFoundException(String object, Integer id) {

        super(String.format(" %s : Page  with Id %d not found", object, id));
    }
}