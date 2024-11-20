package com.es.seguridadsession.exception;

public class BadRequestException extends RuntimeException{
    private static final String DESCRIPCION = "Bad request (400)";
    public BadRequestException(String msg) {
        super(DESCRIPCION + ": " + msg);
    }
}
