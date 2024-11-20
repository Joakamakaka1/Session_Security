package com.es.seguridadsession.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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

    public Session(Long id, String token, LocalDateTime expirationDate, Usuario usuario) {
        this.id = id;
        this.token = token;
        this.expirationDate = expirationDate;
        this.usuario = usuario;
    }

    public Session(String token, LocalDateTime expirationDate, Usuario usuario) {
        this.token = token;
        this.expirationDate = expirationDate;
        this.usuario = usuario;
    }

    public Session(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expirationDate);
    }
}
