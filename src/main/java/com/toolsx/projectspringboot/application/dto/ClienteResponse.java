package com.toolsx.projectspringboot.application.dto;

public class ClienteResponse {
    private Long id;
    private Long usuarioId;
    private String nombreCompleto;
    private String telefono;

    public ClienteResponse() {
    }

    public ClienteResponse(Long id, Long usuarioId, String nombreCompleto, String telefono) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
