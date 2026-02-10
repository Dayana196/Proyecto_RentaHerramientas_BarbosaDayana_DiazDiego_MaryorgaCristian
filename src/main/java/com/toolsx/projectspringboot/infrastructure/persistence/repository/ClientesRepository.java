package com.toolsx.projectspringboot.infrastructure.persistence.repository;

import com.toolsx.projectspringboot.infrastructure.persistence.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClientesRepository extends JpaRepository<ClienteEntity, Long> {
    Optional<ClienteEntity> findByNombreCompleto(String nombreCompleto);
    Optional<ClienteEntity> findByUsuarioId(Long usuarioId);
}
