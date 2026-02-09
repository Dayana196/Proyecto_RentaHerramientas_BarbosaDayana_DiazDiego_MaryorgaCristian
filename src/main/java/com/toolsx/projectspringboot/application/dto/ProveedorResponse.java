package com.toolsx.projectspringboot.application.dto;

public class ProveedorResponse {
    private Long id;
    private String nombreEmpresa;
    private String telefonoContacto;
    private Long usuarioId;

    public ProveedorResponse() {
    }

    public ProveedorResponse(Long id, String nombreEmpresa, String telefonoContacto, Long usuarioId) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.telefonoContacto = telefonoContacto;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
