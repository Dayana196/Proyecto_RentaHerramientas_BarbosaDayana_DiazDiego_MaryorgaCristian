package com.toolsx.projectspringboot.infrastructure.adapters.in.rest.dto;

import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class UsuarioRequest {
    @NotBlank
    private String usuario;

    @NotBlank
    @Email
    private String correo;

    @NotBlank
    private String password;

    @NotEmpty
    private Set<String> roles;

    public UsuarioRequest() {}

    public UsuarioRequest(String usuario, String correo, String password, Set<String> roles) {
        this.usuario = usuario;
        this.correo = correo;
        this.password = password;
        this.roles = roles;
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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
