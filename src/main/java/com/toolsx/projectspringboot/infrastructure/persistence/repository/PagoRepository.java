package com.toolsx.projectspringboot.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolsx.projectspringboot.infrastructure.persistence.entities.PagoEntity;

public interface PagoRepository extends JpaRepository<PagoEntity, Long>{

}
