package com.toolsx.projectspringboot.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolsx.projectspringboot.infrastructure.persistence.entities.HerramientaEntity;

public interface HerramientaRepository extends JpaRepository<HerramientaEntity, Long> {
    List<HerramientaEntity> findByActivaTrue();
    List<HerramientaEntity> findByCategoria_Id(Long categoriaId);
    List<HerramientaEntity> findByProveedor_Id(Long proveedorId);
}
