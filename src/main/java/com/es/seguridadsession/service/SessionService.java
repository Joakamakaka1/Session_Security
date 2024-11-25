package com.es.seguridadsession.service;

import com.es.seguridadsession.exception.BadRequestException;
import com.es.seguridadsession.exception.GenericException;
import com.es.seguridadsession.exception.UnauthorizedAccessException;
import com.es.seguridadsession.model.Session;
import com.es.seguridadsession.repository.SessionRepository;
import com.es.seguridadsession.utils.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * The type Session service.
 */
@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private AESUtil aesUtil;

    /**
     * Check token boolean.
     *
     * @param token the token
     * @return the boolean
     */
    public boolean checkToken(String token) {
        try {
            Session session = sessionRepository.findByToken(token)// Buscar la sesión por token
                    .orElseThrow(() -> new BadRequestException("Token inválido"));

            if (LocalDateTime.now().isAfter(session.getExpirationDate())) { // Verificar si ha expirado
                throw new UnauthorizedAccessException("Token expirado");
            }

            String decryptedData = aesUtil.decrypt(token); // Desencriptar el token y validar el formato
            if (!decryptedData.contains(":clave_secreta")) {
                throw new BadRequestException("El formato de token no válido");
            }

            return true;
        } catch (Exception e) {
            throw new GenericException("Error al validar el token" + e.getMessage());
        }
    }

    /**
     * Gets role from token.
     *
     * @param token the token
     * @return the role from token
     */
    public String getRoleFromToken(String token) {
        try {
            Session session = sessionRepository.findByToken(token)
                    .orElseThrow(() -> new BadRequestException("Token inválido"));

            if (session.isExpired()) {
                throw new UnauthorizedAccessException("Token expirado");
            }

            return session.getUsuario().getRol();
        } catch (Exception e) {
            throw new GenericException("Error al obtener el rol" + e.getMessage());
        }
    }
}
