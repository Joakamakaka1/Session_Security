package com.es.seguridadsession.controller;

import com.es.seguridadsession.dto.ProductoDTO;
import com.es.seguridadsession.service.ProductoService;
import com.es.seguridadsession.service.SessionService;
import com.es.seguridadsession.service.UsuarioService;
import com.es.seguridadsession.utils.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<ProductoDTO> getById(@PathVariable String id, HttpServletRequest request) {
        try {
            String token = tokenUtils.extractTokenFromCookies(request);
            if (!sessionService.checkToken(token)) {
                return ResponseEntity.status(401).build();
            }

            String role = sessionService.getRoleFromToken(token);
            if (!role.equals("User") && !role.equals("Admin")) {
                return ResponseEntity.status(403).build();
            }

            ProductoDTO producto = productoService.getById(id);
            return ResponseEntity.ok(producto);

        } catch (Exception e) {
            return ResponseEntity.status(403).body(null);
        }
    }

    @PostMapping("/") // -> http://localhost:8080/productos
    public ResponseEntity<ProductoDTO> insert(@RequestBody ProductoDTO productoDTO, HttpServletRequest request) {
        try {
            String token = tokenUtils.extractTokenFromCookies(request);
            if (!sessionService.checkToken(token)) {
                return ResponseEntity.status(401).build();
            }

            String role = sessionService.getRoleFromToken(token);
            if (!role.equals("Admin")) {
                return ResponseEntity.status(403).build();
            }

            ProductoDTO producto = productoService.insert(productoDTO);
            return ResponseEntity.ok(producto);

        } catch (Exception e) {
            return ResponseEntity.status(403).body(null);
        }
    }
}
