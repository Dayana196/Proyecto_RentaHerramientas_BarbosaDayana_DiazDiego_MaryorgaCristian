package com.toolsx.projectspringboot.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.toolsx.projectspringboot.domain.model.Usuario;
import com.toolsx.projectspringboot.domain.ports.UsuarioRepositoryPort;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.UsuarioEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.mapper.UsuarioMapper;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.UsuarioJpaRepository;

@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository usuarioJpaRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioRepositoryAdapter(
            UsuarioJpaRepository usuarioJpaRepository,
            UsuarioMapper usuarioMapper
    ) {
        this.usuarioJpaRepository = usuarioJpaRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = usuarioMapper.toEntity(usuario);
        UsuarioEntity saved = usuarioJpaRepository.save(entity);
        return usuarioMapper.toDomain(saved);
    }

    @Override
    public Optional<Usuario> findByUsuario(String usuario) {
        return usuarioJpaRepository.findByUsuario(usuario)
                .map(usuarioMapper::toDomain);
    }

    @Override
    public Optional<Usuario> findByCorreo(String correo) {
        return usuarioJpaRepository.findByCorreo(correo)
                .map(usuarioMapper::toDomain);
    }

    @Override
    public boolean existsByUsuario(String usuario) {
        return usuarioJpaRepository.existsByUsuario(usuario);
    }

    @Override
    public boolean existsByCorreo(String correo) {
        return usuarioJpaRepository.existsByCorreo(correo);
    }
}

