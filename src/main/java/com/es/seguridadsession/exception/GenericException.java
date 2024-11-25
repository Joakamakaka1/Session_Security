package com.es.seguridadsession.exception;

/**
 * The type Generic exception.
 */
public class GenericException extends RuntimeException{
    private static final String DESCRIPCION = "Generic error (500)";

    /**
     * Instantiates a new Generic exception.
     *
     * @param msg the msg
     */
    public GenericException(String msg) {
        super(DESCRIPCION + ": " + msg);
    }
}
