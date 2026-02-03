package com.toolsx.projectspringboot.application.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.toolsx.projectspringboot.domain.model.Usuario;
import com.toolsx.projectspringboot.domain.ports.UsuarioRepositoryPort;
import com.toolsx.projectspringboot.infrastructure.adapters.in.rest.dto.LoginRequest;
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


    public Usuario registrar(Usuario usuarioDTO) {
            // 1. Crear la Entidad de Usuario
            UsuarioEntity nuevaEntidad = new UsuarioEntity();
            nuevaEntidad.setUsuario(usuarioDTO.getUsuario());
            nuevaEntidad.setCorreo(usuarioDTO.getCorreo());
            nuevaEntidad.setPassword(passwordEncoder.encode(usuarioDTO.getPassword()));


            // 2. Mapear el rol manual a una Entidad de Rol real
            Set<RolEntity> rolesAsignados = new HashSet<>();
            
            for (String nombreRol : usuarioDTO.getRoles()) {
                // Buscamos el rol en la DB por su nombre (ADMIN, PROVEEDOR, etc.)
                RolEntity rolEncontrado = rolRepository.findByNombre(nombreRol.toUpperCase())
                    .orElseThrow(() -> new RuntimeException("El rol " + nombreRol + " no existe en la DB"));
                
                rolesAsignados.add(rolEncontrado);
            }

            nuevaEntidad.setRoles(rolesAsignados);

            // 3. Guardar (Esto llenará automáticamente la tabla intermedia usuarios_roles)
            UsuarioEntity guardado = usuarioRepository.save(nuevaEntidad);
            
            return usuarioMapper.toDomain(guardado);
        }
    }

