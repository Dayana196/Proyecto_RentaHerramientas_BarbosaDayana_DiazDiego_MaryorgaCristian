package com.toolsx.projectspringboot.application.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class ReservaUpdateRequest {
    @NotNull
    private Long herramientaId;

    @NotNull
    private String estado;

    @NotNull
    private LocalDate fechaReserva;

    public Long getHerramientaId() {
        return herramientaId;
    }

    public void setHerramientaId(Long herramientaId) {
        this.herramientaId = herramientaId;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
