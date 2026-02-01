package com.toolsx.projectspringboot.application.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.toolsx.projectspringboot.domain.model.Usuario;
import com.toolsx.projectspringboot.domain.ports.UsuarioRepositoryPort;
import com.toolsx.projectspringboot.infrastructure.segurity.JwtUtil;

@Service
public class AuthUsuarioService {
    private final UsuarioRepositoryPort usuarioRepositoryPort;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder; 

    public AuthUsuarioService(UsuarioRepositoryPort usuarioRepositoryPort, JwtUtil jwtUtil) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = new BCryptPasswordEncoder(); 
    }

    public String login(String nombreUsuario, String passwordPlano) {
        Usuario usuario = usuarioRepositoryPort.findByUsuario(nombreUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        if (!passwordEncoder.matches(passwordPlano.trim(), usuario.getPassword().trim())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return jwtUtil.generateToken(usuario);
    }

    public Usuario registrar(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_USER");
        usuario.setRoles(roles);
        
        return usuarioRepositoryPort.save(usuario);
    }

}