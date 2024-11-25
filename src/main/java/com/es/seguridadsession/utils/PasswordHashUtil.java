package com.es.seguridadsession.utils;

import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * The type Password hash util.
 */
@Component
public class PasswordHashUtil {
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Hash password string.
     *
     * @param password the password
     * @return the string
     */
    public static String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }

    /**
     * Check password boolean.
     *
     * @param plainPassword  the plain password
     * @param hashedPassword the hashed password
     * @return the boolean
     */
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return passwordEncoder.matches(plainPassword, hashedPassword);
    }
}

