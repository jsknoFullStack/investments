package com.jskno.investmentsbe.exceptions;

public class EntityNotFoundException extends RuntimeException {

    private String entityNotFound;

    public EntityNotFoundException(String entityNotFound, String message) {
        super(message);
        this.entityNotFound = entityNotFound;
    }

    public String getEntityNotFound() {
        return entityNotFound;
    }
}
