package com.toolsx.projectspringboot.infrastructure.persistence.entities;


import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedores")
public class ProveedorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private UsuarioEntity usuario;

    @Column(name = "nombre_empresa", nullable = false)
    private String nombreEmpresa;

    @Column(name = "telefono_contacto")
    private String telefonoContacto;

    @OneToMany(mappedBy = "proveedor")
    private List<HerramientaEntity> herramientas;

    public ProveedorEntity() {
	}


	public ProveedorEntity(Long id, UsuarioEntity usuario, String nombreEmpresa, String telefonoContacto,
			List<HerramientaEntity> herramientas) {
		this.id = id;
		this.usuario = usuario;
		this.nombreEmpresa = nombreEmpresa;
		this.telefonoContacto = telefonoContacto;
		this.herramientas = herramientas;
	}

	public Long getId() {
        return id;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public List<HerramientaEntity> getHerramientas() {
        return herramientas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public void setHerramientas(List<HerramientaEntity> herramientas) {
        this.herramientas = herramientas;
    }

    
}
