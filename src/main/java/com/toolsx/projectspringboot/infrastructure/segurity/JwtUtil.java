package com.toolsx.projectspringboot.infrastructure.segurity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import com.toolsx.projectspringboot.domain.model.Usuario;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long EXPIRATION_TIME = 86400000; // 24 horas

    public String generateToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getUsuario())
                .claim("roles", usuario.getRoles()) 
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }

    // 1. Extrae el nombre de usuario (el "subject")
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // 2. Método genérico para extraer cualquier dato (Claim) del token
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }

    // 3. Verifica si el token aún es válido (no ha expirado)
    public boolean isTokenValid(String token) {
        try {
            return !extractClaim(token, Claims::getExpiration).before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
    
}