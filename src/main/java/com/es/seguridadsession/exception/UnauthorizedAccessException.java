package com.es.seguridadsession.exception;

public class UnauthorizedAccessException extends RuntimeException{
    private static final String DESCRIPCION = "Unauthorized access (403)";
    public UnauthorizedAccessException(String msg) {
        super(DESCRIPCION + ": " + msg);
    }
}
