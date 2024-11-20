package com.es.seguridadsession.utils;

import com.es.seguridadsession.dto.ProductoDTO;
import com.es.seguridadsession.dto.UsuarioDTO;
import com.es.seguridadsession.dto.UsuarioInsertDTO;
import com.es.seguridadsession.model.Producto;
import com.es.seguridadsession.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public ProductoDTO toProductoDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setStock(producto.getStock());
        productoDTO.setPrecio(producto.isPrecio());
        return productoDTO;
    }

    public Producto toProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setStock(productoDTO.getStock());
        producto.setPrecio(productoDTO.isPrecio());
        return producto;
    }

    public UsuarioInsertDTO toUsuarioDTO(Usuario user) {
        UsuarioInsertDTO userDTO = new UsuarioInsertDTO();
        userDTO.setNombre(user.getNombre());
        userDTO.setPassword1(user.getPassword());
        return userDTO;
    }

    public Usuario toUsuario(UsuarioInsertDTO userDTO) {
        Usuario user = new Usuario();
        user.setNombre(userDTO.getNombre());
        user.setPassword(userDTO.getPassword1());
        return user;
    }
}
