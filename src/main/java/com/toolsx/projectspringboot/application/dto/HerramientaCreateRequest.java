package com.toolsx.projectspringboot.application.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class HerramientaCreateRequest {
    @NotBlank
    private String nombre;

    private String descripcion;

    @NotNull
    @Positive
    private BigDecimal precioDiario;

    private Boolean activa = true;

    @NotNull
    private Long proveedorId;

    @NotNull
    private Long categoriaId;

    public HerramientaCreateRequest() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioDiario() {
        return precioDiario;
    }

    public void setPrecioDiario(BigDecimal precioDiario) {
        this.precioDiario = precioDiario;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public Long getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Long proveedorId) {
        this.proveedorId = proveedorId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}
