package com.toolsx.projectspringboot.infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagenes_herramientas")
public class ImagenesHerramientaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String urlImagen;

    @ManyToOne
    @JoinColumn(name = "herramienta_id", nullable = false)
    private HerramientaEntity herramienta;

    public ImagenesHerramientaEntity() {
    }

    public ImagenesHerramientaEntity(Long id, String urlImagen, HerramientaEntity herramienta) {
        this.id = id;
        this.urlImagen = urlImagen;
        this.herramienta = herramienta;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public HerramientaEntity getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(HerramientaEntity herramienta) {
        this.herramienta = herramienta;
    }

    
}
