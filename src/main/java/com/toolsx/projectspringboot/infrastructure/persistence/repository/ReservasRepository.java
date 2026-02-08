package com.toolsx.projectspringboot.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolsx.projectspringboot.infrastructure.persistence.entities.ReservaEntity;

public interface ReservasRepository extends JpaRepository<ReservaEntity, Long> {
    List<ReservaEntity> findByCliente_Id(Long clienteId);
}
