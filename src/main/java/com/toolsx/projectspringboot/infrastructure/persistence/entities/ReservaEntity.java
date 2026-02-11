package com.toolsx.projectspringboot.infrastructure.persistence.entities;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "reservas")
public class ReservaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario; 

    @ManyToOne
    @JoinColumn(name = "herramienta_id", nullable = false)
    private HerramientaEntity herramienta; 

    private LocalDate fechaReserva;

    public ReservaEntity() {
    }

    

    public ReservaEntity(LocalDate fechaReserva, HerramientaEntity herramienta, Long id, UsuarioEntity usuario) {
        this.fechaReserva = fechaReserva;
        this.herramienta = herramienta;
        this.id = id;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public HerramientaEntity getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(HerramientaEntity herramienta) {
        this.herramienta = herramienta;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    
}