package com.es.seguridadsession.service;

import com.es.seguridadsession.model.Session;
import com.es.seguridadsession.repository.SessionRepository;
import com.es.seguridadsession.utils.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    public boolean checkToken(String token) {
        try {
            Session session = sessionRepository.findByToken(token)// Buscar la sesión por token
                    .orElseThrow(() -> new IllegalArgumentException("Token inválido"));

            if (LocalDateTime.now().isAfter(session.getExpirationDate())) { // Verificar si ha expirado
                throw new IllegalArgumentException("Token expirado");
            }

            // Desencriptar el token y validar el formato
            String decryptedData = AESUtil.decrypt(token);
            if (!decryptedData.contains(":clave_secreta")) {
                throw new IllegalArgumentException("El formato de token no válido");
            }

            return true;
        } catch (Exception e) {
            throw new RuntimeException("Error al validar el token: " + e.getMessage());
        }
    }

    public String getRoleFromToken(String token) {
        Session session = sessionRepository.findByToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Token inválido"));

        if (session.isExpired()) {
            throw new IllegalArgumentException("Token expirado");
        }

        return session.getUsuario().getRol();
    }
}
