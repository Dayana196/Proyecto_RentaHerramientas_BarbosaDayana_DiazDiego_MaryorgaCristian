package com.toolsx.projectspringboot.domain.model;

public class Proveedor {

    private Long id;
    private Usuario usuario;
    private String nombreEmpresa;
    private String telefonoContacto;
    
    public Proveedor() {
    }

    public Proveedor(Long id, Usuario usuario, String nombreEmpresa, String telefonoContacto) {
        this.id = id;
        this.usuario = usuario;
        this.nombreEmpresa = nombreEmpresa;
        this.telefonoContacto = telefonoContacto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    
}
