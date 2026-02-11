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
@Table(name ="Danos")
public class ReporteDanoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;

    private BigDecimal costoReparacion;

    private LocalDateTime fechaReporte;

    @ManyToOne
    @JoinColumn(name = "reserva_id", nullable = false)
    private ReservaEntity reserva;


    public ReporteDanoEntity() {
    }

    public ReporteDanoEntity(Long id, String descripcion, BigDecimal cosotoReparacion, LocalDateTime fechaReporte,
            ReservaEntity reserva, BigDecimal costoReparacion){
        this.id = id;
        this.descripcion = descripcion;
        this.costoReparacion = costoReparacion;
        this.fechaReporte = fechaReporte;
        this.reserva = reserva;
        }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public BigDecimal getCostoReparacion() {
        return costoReparacion;
    }

    public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }

    public ReservaEntity getReserva() {
        return reserva;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCostoReparacion(BigDecimal costoReparacion) {
        this.costoReparacion = costoReparacion;
    }

    public void setFechaReporte(LocalDateTime fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public void setReserva(ReservaEntity reserva) {
        this.reserva = reserva;
    }

}