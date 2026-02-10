package com.toolsx.projectspringboot.infrastructure.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.toolsx.projectspringboot.infrastructure.persistence.entities.RolEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.UsuarioEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.RolJpaRepository;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.UsuarioJpaRepository;

@Service
public class UsuarioService {

    private final UsuarioJpaRepository usuarioRepo;
    private final RolJpaRepository rolRepo;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioJpaRepository usuarioRepo, RolJpaRepository rolRepo, PasswordEncoder passwordEncoder) {
        this.usuarioRepo = usuarioRepo;
        this.rolRepo = rolRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public UsuarioEntity crearUsuario(String usuario, String correo, String password, Set<String> rolesNombres) {
        UsuarioEntity nuevo = new UsuarioEntity();
        nuevo.setUsuario(usuario);
        nuevo.setCorreo(correo);
        nuevo.setPassword(passwordEncoder.encode(password));

        Set<RolEntity> roles = new HashSet<>();
        if (rolesNombres != null) {
            for (String nombreRol : rolesNombres) {
                RolEntity rol = rolRepo.findByNombre(nombreRol)
                        .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + nombreRol));
                roles.add(rol);
            }
        }
        nuevo.setRoles(roles);

        return usuarioRepo.save(nuevo);
    }
}
