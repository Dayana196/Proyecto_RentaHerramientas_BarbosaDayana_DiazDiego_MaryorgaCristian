package com.toolsx.projectspringboot.domain.ports;

import java.util.Optional;

import com.toolsx.projectspringboot.domain.model.Usuario;

public interface UsuarioRepositoryPort {
    Optional <Usuario> findByUsuario(String nombreUsuario);
    Usuario save(Usuario usuario);
}
