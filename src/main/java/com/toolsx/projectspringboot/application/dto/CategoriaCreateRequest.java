package com.toolsx.projectspringboot.application.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoriaCreateRequest {
    @NotBlank
    private String nombre;

    public CategoriaCreateRequest() {
    }

    public CategoriaCreateRequest(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
