package com.es.seguridadsession.exception;

/**
 * The type Bad request exception.
 */
public class BadRequestException extends RuntimeException{
    private static final String DESCRIPCION = "Bad request (400)";

    /**
     * Instantiates a new Bad request exception.
     *
     * @param msg the msg
     */
    public BadRequestException(String msg) {
        super(DESCRIPCION + ": " + msg);
    }
}
