package com.toolsx.projectspringboot.infrastructure.persistence.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "danos")
public class Dano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private BigDecimal costoReparacion;

    private LocalDateTime fechaReporte;

    @ManyToOne
    @JoinColumn(name = "herramienta_id", nullable = false)
    private HerramientaEntity herramienta;

    public Dano() {
    }

    public Dano(Long id, String descripcion, BigDecimal costoReparacion, LocalDateTime fechaReporte,
            HerramientaEntity herramienta) {
        this.id = id;
        this.descripcion = descripcion;
        this.costoReparacion = costoReparacion;
        this.fechaReporte = fechaReporte;
        this.herramienta = herramienta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public HerramientaEntity getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(HerramientaEntity herramienta) {
        this.herramienta = herramienta;
    }

    
}