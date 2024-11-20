package com.es.seguridadsession.exception;

public class GenericException extends RuntimeException{
    private static final String DESCRIPCION = "Generic error (500)";
    public GenericException(String msg) {
        super(DESCRIPCION + ": " + msg);
    }
}
