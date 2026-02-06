package com.toolsx.projectspringboot.domain.model;

import java.time.LocalDateTime;

public class Factura {
    private Long id;
    private Pago pago;
    private String numeroFactura;
    private LocalDateTime fechaEmision;
    
    public Factura() {
    }

    public Factura(Long id, Pago pago, String numeroFactura, LocalDateTime fechaEmision) {
        this.id = id;
        this.pago = pago;
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
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
    
}
