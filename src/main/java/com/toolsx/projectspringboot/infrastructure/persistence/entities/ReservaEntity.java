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
    private UsuarioEntity usuario; // 👈 Usar la entidad JPA

    @Column(length = 20)
    private String estado;

    @ManyToOne
    @JoinColumn(name = "herramienta_id", nullable = false)
    private HerramientaEntity herramienta; // 👈 Usar la entidad JPA

    private LocalDate fechaReserva;

    public ReservaEntity() {
    }

    public ReservaEntity(Long id, UsuarioEntity usuario, String estado, HerramientaEntity herramienta,
            LocalDate fechaReserva) {
        this.id = id;
        this.usuario = usuario;
        this.estado = estado;
        this.herramienta = herramienta;
        this.fechaReserva = fechaReserva;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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