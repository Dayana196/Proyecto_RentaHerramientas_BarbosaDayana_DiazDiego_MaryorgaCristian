package com.toolsx.projectspringboot.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ClienteCreateRequest {
    @NotNull
    private Long usuarioId;

    @NotBlank
    private String nombreCompleto;

    @NotBlank
    private String telefono;

    public ClienteCreateRequest() {
    }

    public ClienteCreateRequest(Long usuarioId, String nombreCompleto, String telefono) {
        this.usuarioId = usuarioId;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

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
