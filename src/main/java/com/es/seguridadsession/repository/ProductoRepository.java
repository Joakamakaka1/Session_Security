package com.es.seguridadsession.repository;

import com.es.seguridadsession.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Producto repository.
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    /**
     * Find by nombre optional.
     *
     * @param nombre the nombre
     * @return the optional
     */
    Optional<Producto> findByNombre(String nombre);
}
