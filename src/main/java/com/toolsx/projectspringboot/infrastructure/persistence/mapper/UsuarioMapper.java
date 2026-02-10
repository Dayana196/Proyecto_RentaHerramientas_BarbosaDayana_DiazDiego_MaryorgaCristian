package com.toolsx.projectspringboot.infrastructure.persistence.mapper;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.toolsx.projectspringboot.domain.model.Usuario;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.RolEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.UsuarioEntity;

@Component
public class UsuarioMapper {

    public Usuario toDomain(UsuarioEntity entity) {
        List<String> roles = entity.getRoles() == null
                ? Collections.emptyList()
                : entity.getRoles().stream().map(RolEntity::getNombre).toList();

        return new Usuario(
            entity.getId(),
            entity.getUsuario(),
            entity.getCorreo(),
            entity.getPassword(),
            roles
        );
    }

    public UsuarioEntity toEntity(Usuario usuario) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(usuario.getId());
        entity.setUsuario(usuario.getUsuario());
        entity.setCorreo(usuario.getCorreo());
        entity.setPassword(usuario.getPassword());
        return entity;
    }

    public Usuario mapToDomain(UsuarioEntity entity) {
        List<String> roles = entity.getRoles().stream()
                                .map(RolEntity::getNombre)
                                .toList();

        return new Usuario(
            entity.getId(),
            entity.getUsuario(),
            entity.getCorreo(),
            null,
            roles
        );
    }
}
