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

	public DetalleReservaEntity() {
	}

	public DetalleReservaEntity(DetalleReservaId id, BigDecimal precioDiario, ReservaEntity reserva,
			HerramientaEntity herramienta) {
		this.id = id;
		this.precioDiario = precioDiario;
		this.reserva = reserva;
		this.herramienta = herramienta;
	}

	public DetalleReservaId getId() {
		return id;
	}

	public void setId(DetalleReservaId id) {
		this.id = id;
	}

	public BigDecimal getPrecioDiario() {
		return precioDiario;
	}

	public void setPrecioDiario(BigDecimal precioDiario) {
		this.precioDiario = precioDiario;
	}

	public ReservaEntity getReserva() {
		return reserva;
	}

	public void setReserva(ReservaEntity reserva) {
		this.reserva = reserva;
	}

	public HerramientaEntity getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(HerramientaEntity herramienta) {
		this.herramienta = herramienta;
	}

    
}
