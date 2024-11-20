package com.es.seguridadsession.exception;

public class CipherException extends RuntimeException {
    private static final String DESCRIPCION = "Cipher error (400)";
    public CipherException(String msg) {
        super(DESCRIPCION + ": " + msg);
    }
}
