package com.toolsx.projectspringboot.domain.ports;

import java.util.Optional;

import com.toolsx.projectspringboot.domain.model.Usuario;

public interface UsuarioRepositoryPort {
    Optional <Usuario> findByUsuario(String nombreUsuario);
    Optional <Usuario> findByCorreo(String correo);
    Usuario save(Usuario usuario); 
    boolean existsByUsuario(String usuario);
    boolean existsByCorreo(String correo);
}
