package com.es.seguridadsession.exception;

/**
 * The type Incorrect password exception.
 */
public class IncorrectPasswordException extends RuntimeException{
    private static final String DESCRIPCION = "Incorrect password (401)";

    /**
     * Instantiates a new Incorrect password exception.
     *
     * @param msg the msg
     */
    public IncorrectPasswordException(String msg) {
        super(DESCRIPCION + ": " + msg);
    }
}
