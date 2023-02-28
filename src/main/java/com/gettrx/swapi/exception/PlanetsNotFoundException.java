package com.gettrx.swapi.exception;

public class PlanetsNotFoundException extends RuntimeException {
    public PlanetsNotFoundException(Integer id) {

        super(String.format("Planets with Id %d not found", id));
    }
}