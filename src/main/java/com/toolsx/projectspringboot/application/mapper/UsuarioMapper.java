package com.toolsx.projectspringboot.application.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.toolsx.projectspringboot.domain.model.Usuario;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.RolEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.UsuarioEntity;

@Component
public class UsuarioMapper {
    public Usuario toDomain(UsuarioEntity entity) {
        if (entity == null) return null;
        Usuario usuario = new Usuario();
        usuario.setId(entity.getId());
        usuario.setUsuario(entity.getUsuario());
        usuario.setPassword(entity.getPassword());
        
        if (entity.getRoles() != null) {
            usuario.setRoles(entity.getRoles().stream()
                    .map(RolEntity::getNombre)
                    .collect(Collectors.toList()));
        } else {
            usuario.setRoles(new java.util.ArrayList<>());
        }
        return usuario;
    }

    public UsuarioEntity toEntity(Usuario domain){
       if (domain == null) return null;

        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(domain.getId());
        entity.setUsuario(domain.getUsuario());
        entity.setCorreo(domain.getCorreo());
        entity.setPassword(domain.getPassword());

        if (domain.getRoles() != null) {
            Set<RolEntity> rolesEntity = domain.getRoles().stream()
                .map(nombreRol -> {
                    RolEntity rol = new RolEntity();
                    rol.setNombre(nombreRol); 
                    return rol;
                })
                .collect(Collectors.toSet());
            entity.setRoles(rolesEntity);
        }

        return entity;
    }
}
