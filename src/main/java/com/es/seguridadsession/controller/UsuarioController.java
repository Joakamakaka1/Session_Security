package com.es.seguridadsession.controller;

import com.es.seguridadsession.dto.UsuarioDTO;
import com.es.seguridadsession.dto.UsuarioInsertDTO;

import com.es.seguridadsession.service.UsuarioService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login") // -> http://localhost:8080/usuarios/login
    public ResponseEntity<UsuarioDTO> login(@RequestBody UsuarioDTO userLogin, HttpServletResponse response) {
       try{
           if(userLogin == null || userLogin.getNombre() == null || userLogin.getPassword() == null) {
               return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
           }

           String token = usuarioService.login(userLogin);

           Cookie cookie = new Cookie("tokenSession", token); // Guardar el token como cookie
           cookie.setHttpOnly(true);
           cookie.setMaxAge(120); // 2 minutos
           response.addCookie(cookie);
           return new ResponseEntity<>(HttpStatus.OK);
       } catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
       }
    }
    @PostMapping("/") // -> http://localhost:8080/usuarios
    public ResponseEntity<UsuarioInsertDTO> insert(@RequestBody UsuarioInsertDTO nuevoUser) {
        try {
            if(nuevoUser == null || nuevoUser.getNombre() == null || nuevoUser.getPassword1() == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            usuarioService.insert(nuevoUser);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /*
    {
        "nombre": "admin",
        "password": "admin",
        "rol": "admin"
    }
     */
}
