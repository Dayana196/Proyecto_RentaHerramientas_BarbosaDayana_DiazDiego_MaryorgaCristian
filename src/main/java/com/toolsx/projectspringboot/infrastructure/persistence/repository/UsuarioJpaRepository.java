package com.toolsx.projectspringboot.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toolsx.projectspringboot.infrastructure.persistence.entities.UsuarioEntity;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long>{

    Optional <UsuarioEntity> findByUsuario(String usuario);
} 
