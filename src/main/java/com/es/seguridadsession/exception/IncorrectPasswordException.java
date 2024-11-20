package com.es.seguridadsession.exception;

public class IncorrectPasswordException extends RuntimeException{
    private static final String DESCRIPCION = "Incorrect password (401)";
    public IncorrectPasswordException(String msg) {
        super(DESCRIPCION + ": " + msg);
    }
}
