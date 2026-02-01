package com.toolsx.projectspringboot.infrastructure.adapters;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.toolsx.projectspringboot.application.mapper.UsuarioMapper;
import com.toolsx.projectspringboot.domain.model.Usuario;
import com.toolsx.projectspringboot.domain.ports.UsuarioRepositoryPort;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.RolEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.UsuarioEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.RolJpaRepository;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.UsuarioJpaRepository;

@Component
public class UsuarioPersistenceAdapter implements UsuarioRepositoryPort {
    
    private final UsuarioJpaRepository jpaRepository;
    private final RolJpaRepository rolRepository; // <--- Nuevo: Repositorio de roles
    private final UsuarioMapper mapper;

    // Actualizamos el constructor para inyectar el nuevo repositorio
    public UsuarioPersistenceAdapter(UsuarioJpaRepository jpaRepository, 
                                     RolJpaRepository rolRepository, 
                                     UsuarioMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.rolRepository = rolRepository;
        this.mapper = mapper;
    }

    @Override
    public Optional<Usuario> findByUsuario(String nombreUsuario) {
        return jpaRepository.findByUsuario(nombreUsuario)
                .map(mapper::toDomain);
    }

    @Override
    public Usuario save(Usuario usuario) {
        // 1. Convertimos el modelo de dominio a la entidad JPA
        UsuarioEntity entity = mapper.toEntity(usuario);
        
        // 2. IMPORTANTE: Buscamos los roles en la DB y se los asignamos a la entidad
        // Sin esto, la tabla intermedia 'usuarios_roles' quedará vacía.
        if (usuario.getRoles() != null && !usuario.getRoles().isEmpty()) {
            Set<RolEntity> rolEntities = usuario.getRoles().stream()
                .map(nombreRol -> rolRepository.findByNombre(nombreRol)
                    .orElseThrow(() -> new RuntimeException("Error: El rol " + nombreRol + " no existe en la base de datos")))
                .collect(Collectors.toSet());
            
            entity.setRoles(rolEntities);
        }

        // 3. Guardamos y convertimos de vuelta a dominio
        UsuarioEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }
}
