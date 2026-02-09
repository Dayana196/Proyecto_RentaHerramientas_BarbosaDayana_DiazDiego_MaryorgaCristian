package com.toolsx.projectspringboot.infrastructure.persistence.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "facturas")
public class FacturaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroFactura;

    private LocalDateTime fechaEmision;

    @OneToOne
    @JoinColumn(name = "pago_id", unique = true)
    private PagoEntity pago;

	public FacturaEntity() {
	}

	public FacturaEntity(Long id, String numeroFactura, LocalDateTime fechaEmision, PagoEntity pago) {
		this.id = id;
		this.numeroFactura = numeroFactura;
		this.fechaEmision = fechaEmision;
		this.pago = pago;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public PagoEntity getPago() {
		return pago;
	}

	public void setPago(PagoEntity pago) {
		this.pago = pago;
	}

    
}
