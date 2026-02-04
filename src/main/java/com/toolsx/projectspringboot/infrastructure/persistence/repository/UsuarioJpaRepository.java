package com.toolsx.projectspringboot.infrastructure.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toolsx.projectspringboot.domain.model.Usuario;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.UsuarioEntity;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long>{

     boolean existsByUsuario(String usuario);
     boolean existsByCorreo(String correo);
     Optional<UsuarioEntity> findByUsuario(String usuario);
     Optional<UsuarioEntity> findByCorreo(String correo);
} 
