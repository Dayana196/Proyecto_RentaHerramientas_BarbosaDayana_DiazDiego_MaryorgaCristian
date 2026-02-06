package com.toolsx.projectspringboot.domain.model;

import java.math.BigDecimal;

public class DetalleReserva {
    private Reserva reserva;
    private Herramienta herramienta;
    private BigDecimal precioDiario;
    
    public DetalleReserva() {
    }

    public DetalleReserva(Reserva reserva, Herramienta herramienta, BigDecimal precioDiario) {
        this.reserva = reserva;
        this.herramienta = herramienta;
        this.precioDiario = precioDiario;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    public BigDecimal getPrecioDiario() {
        return precioDiario;
    }

    public void setPrecioDiario(BigDecimal precioDiario) {
        this.precioDiario = precioDiario;
    }

    
}
