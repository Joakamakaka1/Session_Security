package com.es.seguridadsession.controller;

import com.es.seguridadsession.dto.UsuarioDTO;
import com.es.seguridadsession.dto.UsuarioInsertDTO;

import com.es.seguridadsession.exception.BadRequestException;
import com.es.seguridadsession.exception.ErrorMsgForClient;
import com.es.seguridadsession.exception.GenericException;
import com.es.seguridadsession.exception.UnauthorizedAccessException;
import com.es.seguridadsession.service.UsuarioService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The type Usuario controller.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Login response entity.
     *
     * @param userLogin the user login
     * @param response  the response
     * @return the response entity
     */
    @PostMapping("/login") // -> http://localhost:8080/usuarios/login
    public ResponseEntity<?> login(@RequestBody UsuarioDTO userLogin, HttpServletResponse response) {
        try {
            String token = usuarioService.login(userLogin);

            Cookie cookie = new Cookie("tokenSession", token);
            cookie.setHttpOnly(true);
            cookie.setMaxAge(120); // 2 minutos
            response.addCookie(cookie);
            return new ResponseEntity<>(userLogin, HttpStatus.OK);
        } catch (BadRequestException e) {
            ErrorMsgForClient error = new ErrorMsgForClient(e.getMessage(), "/usuarios/login");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } catch (UnauthorizedAccessException e) {
            ErrorMsgForClient error = new ErrorMsgForClient(e.getMessage(), "/usuarios/login");
            return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
        } catch (GenericException e) {
            ErrorMsgForClient error = new ErrorMsgForClient(e.getMessage(), "/usuarios/login");
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Insert response entity.
     *
     * @param nuevoUser the nuevo user
     * @return the response entity
     */
    @PostMapping // -> http://localhost:8080/usuarios
    public ResponseEntity<?> insert(@RequestBody UsuarioInsertDTO nuevoUser) {
        try {
            UsuarioDTO user = usuarioService.insert(nuevoUser);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (BadRequestException e) {
            ErrorMsgForClient error = new ErrorMsgForClient(e.getMessage(), "/usuarios");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            ErrorMsgForClient error = new ErrorMsgForClient(e.getMessage(), "/usuarios");
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
