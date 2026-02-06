package com.toolsx.projectspringboot.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pago {
    private Long id;
    private Reserva reserva;
    private BigDecimal monto;
    private String metodo;
    private String estado;
    private LocalDateTime fechaPago;

    public Pago() {
    }

    public Pago(Long id, Reserva reserva, BigDecimal monto, String metodo, String estado, LocalDateTime fechaPago) {
        this.id = id;
        this.reserva = reserva;
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

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
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
