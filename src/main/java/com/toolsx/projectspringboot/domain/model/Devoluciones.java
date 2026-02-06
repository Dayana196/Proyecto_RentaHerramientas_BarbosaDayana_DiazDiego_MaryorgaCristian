package com.toolsx.projectspringboot.domain.model;

import java.time.LocalDate;

public class Devoluciones {
    private Long id;
    private Reserva reserva;
    private LocalDate fechaDeDevolucion;
    private String observaciones;

    public Devoluciones() {
    }

    public Devoluciones(Long id, Reserva reserva, LocalDate fechaDeDevolucion, String observaciones) {
        this.id = id;
        this.reserva = reserva;
        this.fechaDeDevolucion = fechaDeDevolucion;
        this.observaciones = observaciones;
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

    public LocalDate getFechaDeDevolucion() {
        return fechaDeDevolucion;
    }

    public void setFechaDeDevolucion(LocalDate fechaDeDevolucion) {
        this.fechaDeDevolucion = fechaDeDevolucion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    
    
}
