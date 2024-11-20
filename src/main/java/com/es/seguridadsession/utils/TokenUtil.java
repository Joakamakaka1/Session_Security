package com.es.seguridadsession.utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * The type Token util.
 */
@Component
public class TokenUtil {
    /**
     * Gets token from cookies.
     *
     * @param request the request
     * @return the token from cookies
     */
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

    /**
     * Extract token from cookies string.
     *
     * @param request the request
     * @return the string
     */
    public String extractTokenFromCookies(HttpServletRequest request) {
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("tokenSession")) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
