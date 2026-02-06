package com.toolsx.projectspringboot.infrastructure.persistence.entities;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class DetalleReservaId implements Serializable {

    private Long reservaId;
    private Long herramientaId;

    public DetalleReservaId() {
    }

    public DetalleReservaId(Long reservaId, Long herramientaId) {
        this.reservaId = reservaId;
        this.herramientaId = herramientaId;
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public Long getHerramientaId() {
        return herramientaId;
    }

    public void setHerramientaId(Long herramientaId) {
        this.herramientaId = herramientaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetalleReservaId that = (DetalleReservaId) o;

        return Objects.equals(reservaId, that.reservaId)
                && Objects.equals(herramientaId, that.herramientaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservaId, herramientaId);
    }
}


