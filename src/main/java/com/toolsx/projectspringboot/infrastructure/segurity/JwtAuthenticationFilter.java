package com.toolsx.projectspringboot.infrastructure.segurity;

import java.io.IOException;
import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.toolsx.projectspringboot.domain.model.Usuario;
import com.toolsx.projectspringboot.domain.ports.UsuarioRepositoryPort;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public JwtAuthenticationFilter(
            JwtUtil jwtUtil,
            UsuarioRepositoryPort usuarioRepositoryPort
    ) {
        this.jwtUtil = jwtUtil;
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        // 🔹 Si no hay token, continúa (rutas públicas)
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);
        String correo = jwtUtil.extractUsername(token); // sub = correo

        if (correo != null &&
            SecurityContextHolder.getContext().getAuthentication() == null) {

            Usuario usuario = usuarioRepositoryPort
                    .findByCorreo(correo)   // 🔥 CAMBIO CLAVE
                    .orElse(null);

            if (usuario != null && jwtUtil.isTokenValid(token)) {

                UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(
                        usuario,
                        null,
                        Collections.emptyList()
                    );

                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}