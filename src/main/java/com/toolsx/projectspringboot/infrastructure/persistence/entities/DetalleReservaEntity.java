package com.toolsx.projectspringboot.infrastructure.persistence.entities;

import java.math.BigDecimal;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle_reservas")
public class DetalleReservaEntity {
    @EmbeddedId
    private DetalleReservaId id;

    private BigDecimal precioDiario;

    @ManyToOne
    @MapsId("reservaId")
    @JoinColumn(name = "reserva_id")
    private ReservaEntity reserva;

    @ManyToOne
    @MapsId("herramientaId")
    @JoinColumn(name = "herramienta_id")
    private HerramientaEntity herramienta;
}
