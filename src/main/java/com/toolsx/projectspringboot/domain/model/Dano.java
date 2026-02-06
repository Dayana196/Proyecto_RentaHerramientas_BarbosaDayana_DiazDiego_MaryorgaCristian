package com.toolsx.projectspringboot.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Dano {
    private Long id;
    private Herramienta herramienta;
    private String descripcion;
    private BigDecimal costoReparacion;
    private LocalDateTime fechaReporte;
    
    public Dano() {
    }

    public Dano(Long id, Herramienta herramienta, String descripcion, BigDecimal costoReparacion,
            LocalDateTime fechaReporte) {
        this.id = id;
        this.herramienta = herramienta;
        this.descripcion = descripcion;
        this.costoReparacion = costoReparacion;
        this.fechaReporte = fechaReporte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCostoReparacion() {
        return costoReparacion;
    }

    public void setCostoReparacion(BigDecimal costoReparacion) {
        this.costoReparacion = costoReparacion;
    }

    public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDateTime fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    
}
