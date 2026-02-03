package com.toolsx.projectspringboot.infrastructure.adapters.in.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolsx.projectspringboot.application.services.AuthUsuarioService;
import com.toolsx.projectspringboot.domain.model.Usuario;
import com.toolsx.projectspringboot.infrastructure.adapters.in.rest.dto.LoginRequest;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthRestController {
    
    private final AuthUsuarioService authService;
    

    public AuthRestController(AuthUsuarioService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody LoginRequest request) {
            try {
                return ResponseEntity.ok("Inicio de sesión exitoso");
            } catch (RuntimeException e) {
                return ResponseEntity.status(401).body(Map.of("error", e.getMessage()));
            }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario usuario) {
        try {
            System.out.println("DEBUG -> Petición de registro recibida para: " + usuario.getUsuario());
            
            Usuario guardado = authService.registrar(usuario);
            return ResponseEntity.ok(guardado);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error interno: " + e.getMessage());
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(){
        return ResponseEntity.ok("Sesión cerrada exitosamente. Recuerde eliminar el token del almacenamiento local.");
    }
}
