package com.toolsx.projectspringboot.infrastructure.adapters.in.controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.toolsx.projectspringboot.application.services.AuthUsuarioService;
import com.toolsx.projectspringboot.domain.model.Usuario;
import com.toolsx.projectspringboot.infrastructure.adapters.in.rest.dto.LoginRequest;
import com.toolsx.projectspringboot.infrastructure.adapters.in.rest.dto.UsuarioRequest;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthRestController {
    
    private final AuthUsuarioService authService;
    

    public AuthRestController(AuthUsuarioService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request) {
        String token = authService.login(
                request.getCorreo(),
                request.getPassword()
        );

        return ResponseEntity.ok(
            Map.of("token", token)
        );
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody UsuarioRequest usuarioRequest) {
        Usuario guardado = authService.registrar(usuarioRequest);
        return ResponseEntity.ok(guardado);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(){
        return ResponseEntity.ok("Sesion cerrada exitosamente. Elimine el token del almacenamiento local.");
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validateToken() {
        return ResponseEntity.ok().build();
    }
}
