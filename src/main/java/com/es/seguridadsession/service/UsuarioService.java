package com.es.seguridadsession.service;

import com.es.seguridadsession.dto.UsuarioDTO;
import com.es.seguridadsession.dto.UsuarioInsertDTO;
import com.es.seguridadsession.exception.BadRequestException;
import com.es.seguridadsession.exception.GenericException;
import com.es.seguridadsession.exception.ResourceNotFoundException;
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

/**
 * The type Usuario service.
 */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private Mapper mapper;
    @Autowired
    private AESUtil aesUtil;

    /**
     * Login string.
     *
     * @param userLogin the user login
     * @return the string
     */
    public String login(UsuarioDTO userLogin) {
        String nombreUser = userLogin.getNombre();
        String passUser = userLogin.getPassword();

        if(nombreUser == null || passUser == null) {
            throw new BadRequestException("El nombre de usuario y la contraseña no pueden ser nulos");
        }

        Usuario usuario = usuarioRepository.findByNombre(nombreUser)
                .stream()
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("El usuario no existe"));

        if (!PasswordHashUtil.checkPassword(passUser, usuario.getPassword())) {
            throw new BadRequestException("Contraseña incorrecta");
        }

        try {
            String token = aesUtil.encrypt(nombreUser + ":claveSecreta"); // Generar token cifrado

            Session session = new Session();
            session.setToken(token);
            session.setUsuario(usuario);
            session.setExpirationDate(LocalDateTime.now().plusMinutes(1)); // Sesión válida por 2 minutos

            sessionRepository.save(session);
            return token;
        } catch (Exception e) {
            throw new GenericException("Error al generar el token" + e.getMessage());
        }
    }

    /**
     * Insert usuario insert dto.
     *
     * @param nuevoUser the nuevo user
     * @return the usuario insert dto
     */
    public UsuarioDTO insert(UsuarioInsertDTO nuevoUser) {
        if (nuevoUser == null) {
            throw new BadRequestException("El usuario no puede ser nulo");
        }

        if (!nuevoUser.getPassword1().equals(nuevoUser.getPassword2())) {
            throw new BadRequestException("Las contraseñas no coinciden");
        }

        if (!nuevoUser.getRol().equals("admin") && !nuevoUser.getRol().equals("user")) {
            throw new BadRequestException("El rol debe ser admin o user");
        }

        try {
            Usuario user = mapper.toUsuario(nuevoUser);  // Convertir el DTO a una entidad Usuario

            if (user.getRol() == null || user.getRol().isEmpty()) {
                throw new BadRequestException("El rol no puede ser nulo o vacío");
            }

            user = usuarioRepository.save(user);
            return mapper.toUsuarioDTO(user);// Retorna el DTO del usuario sin la contraseña2
        } catch (Exception e) {
            throw new GenericException("Error al crear el usuario: " + e.getMessage());
        }
    }
}
