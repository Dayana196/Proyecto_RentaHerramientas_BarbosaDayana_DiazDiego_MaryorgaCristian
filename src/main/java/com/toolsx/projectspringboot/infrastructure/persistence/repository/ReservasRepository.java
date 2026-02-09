package com.toolsx.projectspringboot.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolsx.projectspringboot.infrastructure.persistence.entities.ReservaEntity;

public interface ReservasRepository extends JpaRepository<ReservaEntity, Long> {
        // Antes: findByCliente_Id
    List<ReservaEntity> findByUsuario_Id(Long usuarioId);
}
