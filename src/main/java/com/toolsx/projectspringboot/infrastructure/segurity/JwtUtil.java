package com.toolsx.projectspringboot.infrastructure.segurity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import com.toolsx.projectspringboot.domain.model.Usuario;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtUtil {

    // 🔥 CLAVE FIJA (mínimo 32 caracteres)
    private static final String SECRET_KEY =
            "toolsx_super_secret_key_2026_seguridad_jwt";

    private final Key key =
            Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8));

    private final long EXPIRATION_TIME = 86400000; // 24 horas

    public String generateToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getUsuario())
                .claim("roles", usuario.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claimsResolver.apply(claims);
    }

    public boolean isTokenValid(String token) {
        try {
            return extractClaim(token, Claims::getExpiration)
                    .after(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}
