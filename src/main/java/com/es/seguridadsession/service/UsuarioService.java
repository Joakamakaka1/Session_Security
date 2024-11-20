package com.es.seguridadsession.service;

import com.es.seguridadsession.dto.UsuarioDTO;
import com.es.seguridadsession.dto.UsuarioInsertDTO;
import com.es.seguridadsession.model.Session;
import com.es.seguridadsession.model.Usuario;
import com.es.seguridadsession.repository.SessionRepository;
import com.es.seguridadsession.repository.UsuarioRepository;
import com.es.seguridadsession.utils.AESUtil;
import com.es.seguridadsession.utils.Mapper;
import com.es.seguridadsession.utils.PasswordHashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private Mapper mapper;

    public String login(UsuarioDTO userLogin) {
        String nombreUser = userLogin.getNombre();
        String passUser = userLogin.getPassword();

        Usuario usuario = usuarioRepository.findByNombre(nombreUser)
                .stream()
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        if (!PasswordHashUtil.checkPassword(passUser, usuario.getPassword())) {
            throw new IllegalArgumentException("Contraseña incorrecta");
        }

        try {
            // Generar token cifrado
            String token = AESUtil.encrypt(nombreUser + ":claveSecreta");
            System.out.println("Token generado: " + token);

            Session session = new Session();
            session.setToken(token);
            session.setUsuario(usuario);
            session.setExpirationDate(LocalDateTime.now().plusMinutes(1)); // Sesión válida por 2 minutos

            sessionRepository.save(session);
            return token;
        } catch (Exception e) {
            throw new RuntimeException("Error al generar el token", e);
        }
    }

    public UsuarioInsertDTO insert(UsuarioInsertDTO nuevoUser) {
        try{
            if(nuevoUser == null) {
                throw new IllegalArgumentException("El usuario no puede ser nulo");
            }

            if(!nuevoUser.getPassword1().equals(nuevoUser.getPassword2())) {
                throw new IllegalArgumentException("Las contraseñas no coinciden");
            }

            if(!nuevoUser.getRol().equals("admin") && !nuevoUser.getRol().equals("user")) {
                throw new IllegalArgumentException("El rol debe ser admin o user");
            }

            Usuario user = mapper.toUsuario(nuevoUser);
            user = usuarioRepository.save(user);
            return mapper.toUsuarioDTO(user);
        }catch (Exception e) {
            throw e;
        }
    }
}
