package com.toolsx.projectspringboot.application.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class ReservaCreateRequest {
    @NotNull
    private Long usuarioId;

    @NotNull
    private Long herramientaId;

    @NotNull
    private LocalDate fechaReserva;

    public ReservaCreateRequest() {
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

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
}
