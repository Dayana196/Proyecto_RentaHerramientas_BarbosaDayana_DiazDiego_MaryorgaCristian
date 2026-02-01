package com.toolsx.projectspringboot.infrastructure.segurity;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.toolsx.projectspringboot.domain.ports.UsuarioRepositoryPort;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    private final JwtUtil jwtUtil;
    private final UsuarioRepositoryPort usuarioRepositoryPort;
    
    public JwtAuthenticationFilter(JwtUtil jwtUtil, UsuarioRepositoryPort usuarioRepositoryPort) {
        this.jwtUtil = jwtUtil;
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{
        String authHeader = request.getHeader("Autorizado");

        if (authHeader != null && authHeader.startsWith("Portador ")){
            String token = authHeader.substring(7);
            String username = jwtUtil.extractUsername(token);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                usuarioRepositoryPort.findByUsuario(username).ifPresent(usuario -> {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                            usuario, null, new ArrayList<>()
                    );
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                });
            }
        }
        filterChain.doFilter(request, response);
    }
}
