package com.toolsx.projectspringboot.application.dto;

import java.math.BigDecimal;

public class HerramientaResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precioDiario;
    private Boolean activa;
    private Long proveedorId;
    private Long categoriaId;

    public HerramientaResponse() {
    }

    public HerramientaResponse(Long id, String nombre, String descripcion, BigDecimal precioDiario, Boolean activa,
            Long proveedorId, Long categoriaId) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioDiario = precioDiario;
        this.activa = activa;
        this.proveedorId = proveedorId;
        this.categoriaId = categoriaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
