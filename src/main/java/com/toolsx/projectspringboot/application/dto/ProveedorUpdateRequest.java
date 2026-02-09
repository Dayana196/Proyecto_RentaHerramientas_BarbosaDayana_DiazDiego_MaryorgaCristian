package com.toolsx.projectspringboot.application.dto;

import jakarta.validation.constraints.NotBlank;

public class ProveedorUpdateRequest {

    @NotBlank
    private String nombreEmpresa;

    @NotBlank
    private String telefonoContacto;

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
}