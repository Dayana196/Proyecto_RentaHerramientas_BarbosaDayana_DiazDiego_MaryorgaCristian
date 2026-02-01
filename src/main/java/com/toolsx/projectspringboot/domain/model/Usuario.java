package com.toolsx.projectspringboot.domain.model;


import java.util.List;

public class Usuario {
    private Long id;
    private String usuario;
    private String correo;
    private String password;
    private List<String> roles;
    
    public Usuario() {
    }

    public Usuario(Long id, String usuario, String correo, String password, List<String> roles) {
        this.id = id;
        this.usuario = usuario;
        this.correo = correo;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    
}
