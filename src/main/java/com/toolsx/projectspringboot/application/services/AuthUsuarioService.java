package com.toolsx.projectspringboot.application.services;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.toolsx.projectspringboot.domain.model.Usuario;
import com.toolsx.projectspringboot.domain.ports.UsuarioRepositoryPort;
import com.toolsx.projectspringboot.infrastructure.adapters.in.rest.dto.UsuarioRequest;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.RolEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.entities.UsuarioEntity;
import com.toolsx.projectspringboot.infrastructure.persistence.mapper.UsuarioMapper;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.RolJpaRepository;
import com.toolsx.projectspringboot.infrastructure.persistence.repository.UsuarioJpaRepository;
import com.toolsx.projectspringboot.infrastructure.segurity.JwtUtil;


@Service
public class AuthUsuarioService {
    private final UsuarioRepositoryPort usuarioRepositoryPort;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder; 
    private final UsuarioMapper usuarioMapper;
    private final RolJpaRepository rolRepository;
    private final UsuarioJpaRepository usuarioRepository;

    public AuthUsuarioService(UsuarioRepositoryPort usuarioRepositoryPort, JwtUtil jwtUtil,
            PasswordEncoder passwordEncoder, UsuarioMapper usuarioMapper, RolJpaRepository rolRepository,
            UsuarioJpaRepository usuarioRepository) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
        this.usuarioMapper = usuarioMapper;
        this.rolRepository = rolRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public String login(String correo, String passwordPlano) {

        Usuario usuario = usuarioRepositoryPort.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no existe"));

        if (!passwordEncoder.matches(passwordPlano, usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        // 🔐 AQUÍ se genera el JWT
        return jwtUtil.generateToken(usuario);
    }


    public Usuario registrar(UsuarioRequest usuarioRequest) {
        // 1. Convertir roles a entidades RolEntity
        Set<RolEntity> roles = usuarioRequest.getRoles().stream()
            .map(nombre -> rolRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + nombre))
            )
            .collect(Collectors.toSet());

        // 2. Crear la entidad UsuarioEntity
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setUsuario(usuarioRequest.getUsuario());
        usuarioEntity.setCorreo(usuarioRequest.getCorreo());
        usuarioEntity.setPassword(passwordEncoder.encode(usuarioRequest.getPassword()));
        usuarioEntity.setRoles(roles);

        // 3. Guardar en base de datos
        usuarioEntity = usuarioRepository.save(usuarioEntity);

        // 4. Mapear a dominio
        List<String> nombresRoles = usuarioEntity.getRoles()
            .stream()
            .map(RolEntity::getNombre)
            .toList();

        return new Usuario(
            usuarioEntity.getId(),
            usuarioEntity.getUsuario(),
            usuarioEntity.getCorreo(),
            null, // nunca devolvemos la contraseña
            nombresRoles
        );
    }
}

