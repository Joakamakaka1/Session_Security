package com.es.seguridadsession.exception;

/**
 * The type Resource not found exception.
 */
public class ResourceNotFoundException extends RuntimeException {
    private static final String DESCRIPCION = "Resource not found (404)";

    /**
     * Instantiates a new Resource not found exception.
     *
     * @param msg the msg
     */
    public ResourceNotFoundException(String msg) {
        super(DESCRIPCION + ": " + msg);
    }
}
