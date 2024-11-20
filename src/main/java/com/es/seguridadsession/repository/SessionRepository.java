package com.es.seguridadsession.repository;

import com.es.seguridadsession.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface Session repository.
 */
@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
    /**
     * Find by token optional.
     *
     * @param token the token
     * @return the optional
     */
    Optional<Session> findByToken(String token);
}
