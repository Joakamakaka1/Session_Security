package com.es.seguridadsession.controller;

import com.es.seguridadsession.exception.ErrorMsgForClient;
import com.es.seguridadsession.exception.UnauthorizedAccessException;
import com.es.seguridadsession.service.SessionService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Ruta protegida controller.
 */
@RestController
@RequestMapping("/rutaProtegida")
public class RutaProtegidaController {
    @Autowired
    private SessionService sessionService;

    /**
     * Ruta protegida response entity.
     *
     * @param request the request
     * @return the response entity
     */
    @PostMapping("/") // -> http://localhost:8080/rutaProtegida
    public ResponseEntity<?> rutaProtegida(HttpServletRequest request) {
        String token = "";
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("tokenSession")) {
                token = cookie.getValue();
            }
        }

        try {
            if (!sessionService.checkToken(token)) {
                throw new UnauthorizedAccessException("Token inválido o expirado");
            }
            return new ResponseEntity<>("RECURSO SUPER IMPORTANTE", HttpStatus.OK);
        } catch (UnauthorizedAccessException e) {
            ErrorMsgForClient error = new ErrorMsgForClient(e.getMessage(), "/rutaProtegida");
            return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
        } catch (Exception e) {
            ErrorMsgForClient error = new ErrorMsgForClient("Error interno del servidor", "/rutaProtegida");
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
