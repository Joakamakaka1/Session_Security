package com.es.seguridadsession.exception;

public class TokenInvalidException extends RuntimeException{
    private static final String DESCRIPCION = "Token invalid (401)";
    public TokenInvalidException(String msg) {
        super(DESCRIPCION + ": " + msg);
    }
}
