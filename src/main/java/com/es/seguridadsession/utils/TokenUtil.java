package com.es.seguridadsession.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class TokenUtil {
    public String getTokenFromCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("tokenSession")) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public String extractTokenFromCookies(HttpServletRequest request) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("tokenSession")) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
