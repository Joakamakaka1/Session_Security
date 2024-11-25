package com.es.seguridadsession.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * The type Session.
 */
@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime expirationDate;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    /**
     * Instantiates a new Session.
     *
     * @param id             the id
     * @param token          the token
     * @param expirationDate the expiration date
     * @param usuario        the usuario
     */
    public Session(Long id, String token, LocalDateTime expirationDate, Usuario usuario) {
        this.id = id;
        this.token = token;
        this.expirationDate = expirationDate;
        this.usuario = usuario;
    }

    /**
     * Instantiates a new Session.
     *
     * @param token          the token
     * @param expirationDate the expiration date
     * @param usuario        the usuario
     */
    public Session(String token, LocalDateTime expirationDate, Usuario usuario) {
        this.token = token;
        this.expirationDate = expirationDate;
        this.usuario = usuario;
    }

    /**
     * Instantiates a new Session.
     */
    public Session(){}

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
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
     * Gets token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets token.
     *
     * @param token the token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Sets expiration date.
     *
     * @param expirationDate the expiration date
     */
    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     * Sets usuario.
     *
     * @param usuario the usuario
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Gets usuario.
     *
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Gets expiration date.
     *
     * @return the expiration date
     */
    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    /**
     * Is expired boolean.
     *
     * @return the boolean
     */
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expirationDate);
    }
}
