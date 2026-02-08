package com.toolsx.projectspringboot.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolsx.projectspringboot.infrastructure.persistence.entities.DetalleReservaEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.DetalleReservaId;

public interface DetalleReservaRepository extends JpaRepository<DetalleReservaEntity, DetalleReservaId > {

}
