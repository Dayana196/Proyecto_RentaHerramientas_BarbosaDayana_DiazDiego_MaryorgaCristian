package com.toolsx.projectspringboot.infrastructure.persistence.repository;

import com.toolsx.projectspringboot.infrastructure.persistence.entities.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RolJpaRepository extends JpaRepository<RolEntity, Long> {
    // Este método es el que usamos en el Adapter para buscar "ROLE_USER"
    Optional<RolEntity> findByNombre(String nombre);
}
