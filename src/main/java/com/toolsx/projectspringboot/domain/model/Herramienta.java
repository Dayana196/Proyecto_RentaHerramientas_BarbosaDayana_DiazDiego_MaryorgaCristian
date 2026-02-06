package com.toolsx.projectspringboot.domain.model;

import java.math.BigDecimal;

public class Herramienta {
    private Long id;
    private Proveedor proveedor;
    private Categoria categoria;
    private String nombre;
    private String descripcion;
    private BigDecimal precioDiario;
    private boolean activa;
    
    public Herramienta() {
    }

    public Herramienta(Long id, Proveedor proveedor, Categoria categoria, String nombre, String descripcion,
            BigDecimal precioDiario, boolean activa) {
        this.id = id;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioDiario = precioDiario;
        this.activa = activa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecioDiario() {
        return precioDiario;
    }

    public void setPrecioDiario(BigDecimal precioDiario) {
        this.precioDiario = precioDiario;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    
}
