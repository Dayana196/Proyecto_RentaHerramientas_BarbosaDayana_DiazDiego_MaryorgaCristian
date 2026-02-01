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
    // 1. Encriptamos la contraseña que viene de Postman
    usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
    
    // 2. Verificamos si enviaste roles en el JSON
    // Si la lista está vacía, puedes lanzar un error o asignar uno por defecto
    if (usuario.getRoles() == null || usuario.getRoles().isEmpty()) {
        List<String> rolesPorDefecto = new ArrayList<>();
        rolesPorDefecto.add("CLIENTE"); // Solo si no mandas nada
        usuario.setRoles(rolesPorDefecto);
    } 
    // Si mandaste ["ADMIN"], ["PROVEEDOR"] o ["CLIENTE"], se quedan esos.

    return usuarioRepositoryPort.save(usuario);
}

}