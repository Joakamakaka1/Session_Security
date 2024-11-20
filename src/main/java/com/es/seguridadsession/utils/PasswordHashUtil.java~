package com.es.seguridadsession.utils;

import org.springframework.stereotype.Component;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Component
public class PasswordHashUtil {
    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public static String hashPassword(String password) {
        return passwordEncoder.encode(password);
    }
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return passwordEncoder.matches(plainPassword, hashedPassword);
    }
}

