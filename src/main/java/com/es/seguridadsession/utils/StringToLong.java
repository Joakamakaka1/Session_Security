package com.es.seguridadsession.utils;

import org.springframework.stereotype.Component;

@Component
public class StringToLong {
    /**
     * String to long.
     *
     * @param id the id
     * @return the long
     */
    public static Long stringToLong(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El id debe ser un número");
        }
    }
}
