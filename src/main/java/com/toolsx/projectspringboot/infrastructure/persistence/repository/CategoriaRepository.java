package com.toolsx.projectspringboot.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toolsx.projectspringboot.infrastructure.persistence.entities.CategoriaEntity;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long>{
    
}
