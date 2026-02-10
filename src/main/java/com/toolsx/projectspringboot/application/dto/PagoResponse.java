package com.toolsx.projectspringboot.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoResponse {
    private Long id;
    private Long reservaId;
    private BigDecimal monto;
    private String metodo;
    private String estado;
    private LocalDateTime fechaPago;

    public PagoResponse() {
    }

    public PagoResponse(Long id, Long reservaId, BigDecimal monto, String metodo, String estado, LocalDateTime fechaPago) {
        this.id = id;
        this.reservaId = reservaId;
        this.monto = monto;
        this.metodo = metodo;
        this.estado = estado;
        this.fechaPago = fechaPago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }
}
