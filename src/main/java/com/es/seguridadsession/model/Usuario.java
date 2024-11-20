package com.es.seguridadsession.model;

import com.es.seguridadsession.utils.PasswordHashUtil;
import jakarta.persistence.*;

/**
 * The type Usuario.
 */
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombre;
    private String password;
    @Column(nullable = false)
    private String rol;

    /**
     * Instantiates a new Usuario.
     *
     * @param id       the id
     * @param nombre   the nombre
     * @param password the password
     * @param rol      the rol
     */
    public Usuario(Long id, String nombre, String password, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.rol = rol;
    }

    /**
     * Instantiates a new Usuario.
     *
     * @param nombre   the nombre
     * @param password the password
     * @param rol      the rol
     */
    public Usuario(String nombre, String password, String rol) {
        this.nombre = nombre;
        setPassword(password);
        this.rol = rol;
    }

    /**
     * Instantiates a new Usuario.
     */
    public Usuario() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Gets rol.
     *
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * Sets rol.
     *
     * @param rol the rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets nombre.
     *
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets nombre.
     *
     * @param nombre the nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = PasswordHashUtil.hashPassword(password);
    }
}
