package com.toolsx.projectspringboot.domain.model;

public class ImagenHerramienta {

    private Long id;
    private Herramienta herramienta;
    private String urlImagen;
    
    public ImagenHerramienta() {
    }

    public ImagenHerramienta(Long id, Herramienta herramienta, String urlImagen) {
        this.id = id;
        this.herramienta = herramienta;
        this.urlImagen = urlImagen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    
}
