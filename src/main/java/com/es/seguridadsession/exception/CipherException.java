package com.es.seguridadsession.exception;

/**
 * The type Cipher exception.
 */
public class CipherException extends RuntimeException {
    private static final String DESCRIPCION = "Cipher error (400)";

    /**
     * Instantiates a new Cipher exception.
     *
     * @param msg the msg
     */
    public CipherException(String msg) {
        super(DESCRIPCION + ": " + msg);
    }
}
