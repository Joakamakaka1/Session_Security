package com.es.seguridadsession.service;

import com.es.seguridadsession.dto.ProductoDTO;
import com.es.seguridadsession.model.Producto;
import com.es.seguridadsession.model.Usuario;
import com.es.seguridadsession.repository.ProductoRepository;
import com.es.seguridadsession.utils.Mapper;
import com.es.seguridadsession.utils.StringToLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private Mapper mapper;

    public ProductoDTO getById(String id) {
        try{
            if(id == null) {
                throw new IllegalArgumentException("El id no puede ser nulo");
            }
            Long idLong = StringToLong.stringToLong(id);
            Producto producto = productoRepository.findById(idLong).orElse(null);
            if(producto == null) {
                throw new IllegalArgumentException("El producto no existe");
            }
            return mapper.toProductoDTO(producto);
        }catch (Exception e) {
            throw e;
        }
    }

    public ProductoDTO insert(ProductoDTO productoDTO) {
        try {
            if(productoDTO == null) {
                throw new IllegalArgumentException("El producto no puede ser nulo");
            }
            Producto producto = mapper.toProducto(productoDTO);
            producto = productoRepository.save(producto);
            return mapper.toProductoDTO(producto);
        }catch (Exception e) {
            throw e;
        }
    }

}
