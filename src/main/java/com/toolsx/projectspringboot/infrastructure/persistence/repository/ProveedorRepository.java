package com.toolsx.projectspringboot.infrastructure.persistence.repository;

import com.toolsx.projectspringboot.domain.model.Proveedor;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.ProveedorEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProveedorRepository
        extends JpaRepository<ProveedorEntity, Long> {

    
    Optional<Proveedor> findByUsuarioId(Long usuarioId);
}