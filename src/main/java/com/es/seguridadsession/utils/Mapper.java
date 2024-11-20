package com.es.seguridadsession.utils;

import com.es.seguridadsession.dto.ProductoDTO;
import com.es.seguridadsession.dto.UsuarioInsertDTO;
import com.es.seguridadsession.model.Producto;
import com.es.seguridadsession.model.Usuario;
import org.springframework.stereotype.Component;

/**
 * The type Mapper.
 */
@Component
public class Mapper {
    /**
     * To producto dto producto dto.
     *
     * @param producto the producto
     * @return the producto dto
     */
    public ProductoDTO toProductoDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setStock(producto.getStock());
        productoDTO.setPrecio(producto.isPrecio());
        return productoDTO;
    }

    /**
     * To producto producto.
     *
     * @param productoDTO the producto dto
     * @return the producto
     */
    public Producto toProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setStock(productoDTO.getStock());
        producto.setPrecio(productoDTO.isPrecio());
        return producto;
    }

    /**
     * To usuario dto usuario insert dto.
     *
     * @param user the user
     * @return the usuario insert dto
     */
    public UsuarioInsertDTO toUsuarioDTO(Usuario user) {
        UsuarioInsertDTO userDTO = new UsuarioInsertDTO();
        userDTO.setNombre(user.getNombre());
        userDTO.setPassword1(user.getPassword());
        return userDTO;
    }

    /**
     * To usuario usuario.
     *
     * @param userDTO the user dto
     * @return the usuario
     */
    public Usuario toUsuario(UsuarioInsertDTO userDTO) {
        Usuario user = new Usuario();
        user.setNombre(userDTO.getNombre());
        user.setPassword(userDTO.getPassword1());
        return user;
    }
}
