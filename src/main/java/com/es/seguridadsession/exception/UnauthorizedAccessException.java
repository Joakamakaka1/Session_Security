package com.es.seguridadsession.exception;

/**
 * The type Unauthorized access exception.
 */
public class UnauthorizedAccessException extends RuntimeException{
    private static final String DESCRIPCION = "Unauthorized access (403)";

    /**
     * Instantiates a new Unauthorized access exception.
     *
     * @param msg the msg
     */
    public UnauthorizedAccessException(String msg) {
        super(DESCRIPCION + ": " + msg);
    }
}
