package com.toolsx.projectspringboot.infrastructure.adapters.in.rest.dto;

public class LoginRequest {
    private String correo;
    private String password;
    public LoginRequest() {
    }
    public LoginRequest(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String usuario) {
        this.correo = usuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
