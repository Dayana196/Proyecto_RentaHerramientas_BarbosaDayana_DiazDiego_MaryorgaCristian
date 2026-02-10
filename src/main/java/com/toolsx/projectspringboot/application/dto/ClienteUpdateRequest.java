package com.toolsx.projectspringboot.application.dto;

import jakarta.validation.constraints.NotBlank;

public class ClienteUpdateRequest {
    @NotBlank
    private String nombreCompleto;

    @NotBlank
    private String telefono;

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
