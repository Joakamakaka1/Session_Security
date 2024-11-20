package com.es.seguridadsession.exception;

/**
 * The type Token invalid exception.
 */
public class TokenInvalidException extends RuntimeException{
    private static final String DESCRIPCION = "Token invalid (401)";

    /**
     * Instantiates a new Token invalid exception.
     *
     * @param msg the msg
     */
    public TokenInvalidException(String msg) {
        super(DESCRIPCION + ": " + msg);
    }
}
