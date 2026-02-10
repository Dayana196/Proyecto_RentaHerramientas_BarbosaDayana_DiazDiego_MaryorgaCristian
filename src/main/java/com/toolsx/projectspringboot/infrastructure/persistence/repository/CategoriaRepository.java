package com.toolsx.projectspringboot.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolsx.projectspringboot.infrastructure.persistence.entities.CategoriaEntity;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
    Optional<CategoriaEntity> findByNombre(String nombre);
}
