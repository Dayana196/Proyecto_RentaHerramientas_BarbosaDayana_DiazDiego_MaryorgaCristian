package com.toolsx.projectspringboot.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class proveedor {
    @NotNull(message = "El usuario es obligatorio")
    private Long usuarioId;

    @NotBlank(message = "El nombre de la empresa es obligatorio")
    private String nombreEmpresa;

    @NotBlank(message = "El teléfono es obligatorio")
    private String telefonoContacto;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    
}
