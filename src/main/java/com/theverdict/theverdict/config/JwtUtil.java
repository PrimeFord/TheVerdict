package com.theverdict.theverdict.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "TXlTdXBlclNlY3JldEtleUluQmFzZTY0U3RyaW5nRm9yVGhlVmVyZGljdA=="; // 256-bit Base64 secret
    private final long EXPIRATION_TIME = 86400000; // 1 day

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(String email, String role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String extractEmail(String token) {
        return extractClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return (String) extractClaims(token).get("role");
    }

    public boolean isTokenValid(String token) {
        return !extractClaims(token).getExpiration().before(new Date());
    }
}
//@Component
//public class JwtUtil {
//
//    private final String SECRET = "very_secret_key";
//    private final long EXPIRATION_TIME = 86400000; // 1 day
//
//    public String generateToken(String email, String role) {
//        return Jwts.builder()
//                .setSubject(email)
//                .claim("role", role)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
//                .signWith(SignatureAlgorithm.HS256, SECRET)
//                .compact();
//    }
//
//    public Claims extractClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(SECRET)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    public String extractEmail(String token) {
//        return extractClaims(token).getSubject();
//    }
//
//    public String extractRole(String token) {
//        return (String) extractClaims(token).get("role");
//    }
//
//    public boolean isTokenValid(String token) {
//        return !extractClaims(token).getExpiration().before(new Date());
//    }
//}
