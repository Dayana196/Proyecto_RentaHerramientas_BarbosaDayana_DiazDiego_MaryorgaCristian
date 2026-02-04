package com.toolsx.projectspringboot.infrastructure.persistence.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.toolsx.projectspringboot.domain.model.Usuario;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.RolEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.UsuarioEntity;

@Component
public class UsuarioMapper {

    public Usuario toDomain(UsuarioEntity entity) {
        Usuario usuario = new Usuario();
        usuario.setId(entity.getId());
        usuario.setUsuario(entity.getUsuario());
        usuario.setCorreo(entity.getCorreo());
        usuario.setPassword(entity.getPassword());
        return usuario;
    }

    public UsuarioEntity toEntity(Usuario usuario) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setId(usuario.getId());
        entity.setUsuario(usuario.getUsuario());
        entity.setCorreo(usuario.getCorreo());
        entity.setPassword(usuario.getPassword());
        return entity;
    }
}

