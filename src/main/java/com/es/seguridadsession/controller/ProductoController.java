package com.es.seguridadsession.controller;

import com.es.seguridadsession.dto.ProductoDTO;
import com.es.seguridadsession.exception.ErrorMsgForClient;
import com.es.seguridadsession.exception.GenericException;
import com.es.seguridadsession.exception.UnauthorizedAccessException;
import com.es.seguridadsession.service.ProductoService;
import com.es.seguridadsession.service.SessionService;
import com.es.seguridadsession.service.UsuarioService;
import com.es.seguridadsession.utils.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenUtil tokenUtils;

    @Autowired
    private SessionService sessionService;

    @GetMapping("/{id}") // -> http://localhost:8080/productos
    public ResponseEntity<?> getById(@PathVariable String id, HttpServletRequest request) {
        try {
            String token = tokenUtils.extractTokenFromCookies(request);
            if (!sessionService.checkToken(token)) {
                throw new UnauthorizedAccessException("Token inválido o expirado");
            }

            String role = sessionService.getRoleFromToken(token);
            if (!role.equals("User") && !role.equals("Admin")) {
                throw new UnauthorizedAccessException("Acceso denegado, se requiere rol 'User' o 'Admin'");
            }

            ProductoDTO producto = productoService.getById(id);
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } catch (UnauthorizedAccessException e) {
            ErrorMsgForClient error = new ErrorMsgForClient(e.getMessage(), "/productos/" + id);
            return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
        } catch (GenericException e) {
            ErrorMsgForClient error = new ErrorMsgForClient(e.getMessage(), "/productos/" + id);
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/") // -> http://localhost:8080/productos
    public ResponseEntity<?> insert(@RequestBody ProductoDTO productoDTO, HttpServletRequest request) {
        try {
            String token = tokenUtils.extractTokenFromCookies(request);
            if (!sessionService.checkToken(token)) {
                throw new UnauthorizedAccessException("Token inválido o expirado");
            }

            String role = sessionService.getRoleFromToken(token);
            if (!role.equals("Admin")) {
                throw new UnauthorizedAccessException("Acceso denegado, se requiere rol 'Admin'");
            }

            ProductoDTO producto = productoService.insert(productoDTO);
            return new ResponseEntity<>(producto, HttpStatus.CREATED);
        } catch (UnauthorizedAccessException e) {
            ErrorMsgForClient error = new ErrorMsgForClient(e.getMessage(), "/productos");
            return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
        } catch (GenericException e) {
            ErrorMsgForClient error = new ErrorMsgForClient(e.getMessage(), "/productos");
            return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
