package com.toolsx.projectspringboot.application.dto;

import java.time.LocalDate;

public class ReservaResponse {
    private Long id;
    private Long usuarioId;
    private Long herramientaId;
    private String estado;
    private LocalDate fechaReserva;

    public ReservaResponse() {
    }

    public ReservaResponse(Long id, Long usuarioId, Long herramientaId, String estado, LocalDate fechaReserva) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.herramientaId = herramientaId;
        this.estado = estado;
        this.fechaReserva = fechaReserva;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    
}
