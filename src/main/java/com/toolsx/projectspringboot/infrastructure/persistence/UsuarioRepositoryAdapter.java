package com.toolsx.projectspringboot.infrastructure.persistence;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.toolsx.projectspringboot.domain.model.Usuario;
import com.toolsx.projectspringboot.domain.ports.UsuarioRepositoryPort;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.UsuarioEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.mapper.UsuarioMapper;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.UsuarioJpaRepository;

@Repository
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort{

    private UsuarioMapper usuarioMapper;

    private final UsuarioJpaRepository usuarioJpaRepository;

    public UsuarioRepositoryAdapter(UsuarioJpaRepository usuarioJpaRepository, UsuarioMapper usuarioMapper) {
        this.usuarioJpaRepository = usuarioJpaRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setUsuario(usuario.getUsuario());
        entity.setCorreo(usuario.getCorreo());
        entity.setPassword(usuario.getPassword());

        UsuarioEntity saved = usuarioJpaRepository.save(entity);

        Usuario domain = new Usuario();
        domain.setId(saved.getId());
        domain.setUsuario(saved.getUsuario());
        domain.setCorreo(saved.getCorreo());
        domain.setPassword(saved.getPassword());

        return domain;
    }

    @Override
    public Optional<Usuario> findByUsuario(String usuario) {
        return usuarioJpaRepository.findByUsuario(usuario)
                .map(entity -> {
                    Usuario u = new Usuario();
                    u.setId(entity.getId());
                    u.setUsuario(entity.getUsuario());
                    u.setCorreo(entity.getCorreo());
                    u.setPassword(entity.getPassword());
                    return u;
                });
    }

    @Override
    public boolean existsByUsuario(String usuario) {
        return usuarioJpaRepository.existsByUsuario(usuario);
    }

    @Override
    public boolean existsByCorreo(String correo) {
        return usuarioJpaRepository.existsByCorreo(correo);
    }

    @Override
    public Optional<Usuario> findByCorreo(String correo) {
        return usuarioJpaRepository.findByCorreo(correo)
                .map(entity -> usuarioMapper.toDomain(entity));
    }



    

}
