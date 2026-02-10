package com.toolsx.projectspringboot.application.services;

import java.util.List;

import com.toolsx.projectspringboot.infrastructure.persistence.entities.HerramientaEntity;

public interface HerramientasService {
    List<HerramientaEntity> listarTodas();
    List<HerramientaEntity> listarDisponibles();
    List<HerramientaEntity> listarPorCategoria(Long categoriaId);
    List<HerramientaEntity> listarPorProveedor(Long proveedorId);
    HerramientaEntity guardar(HerramientaEntity herramienta);
    HerramientaEntity buscarPorId(Long id);
    void eliminar(Long id);
}
