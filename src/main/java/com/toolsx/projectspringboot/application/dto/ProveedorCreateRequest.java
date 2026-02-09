package com.toolsx.projectspringboot.application.dto;

public class ProveedorCreateRequest {
    private Long usuarioId;
    private String nombreEmpresa;
    private String telefonoContacto;
    
	public ProveedorCreateRequest() {
	}

	public ProveedorCreateRequest(Long usuarioId, String nombreEmpresa, String telefonoContacto) {
		this.usuarioId = usuarioId;
		this.nombreEmpresa = nombreEmpresa;
		this.telefonoContacto = telefonoContacto;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
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
