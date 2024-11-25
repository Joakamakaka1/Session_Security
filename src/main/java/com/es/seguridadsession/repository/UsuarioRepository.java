package com.es.seguridadsession.repository;

import com.es.seguridadsession.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Usuario repository.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    /**
     * Find by nombre list.
     *
     * @param nombre the nombre
     * @return the list
     */
    List<Usuario> findByNombre(String nombre);

}
