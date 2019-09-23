package com.paradecision.config;

import com.paradecision.organizations.users.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenManager {

    private String secret;
    private long expirationInMillis;


    public JwtTokenManager(@Value("${jwt.secret}") String secret, @Value("${jwt.expiration}") long expirationInMillis) {
        this.secret = secret;
        this.expirationInMillis = expirationInMillis;
    }

    public String generateToken(User user){
        final Date now = new Date();
        final Date expiration = new Date(now.getTime() + this.expirationInMillis);
        return Jwts.builder()
                .setIssuer("Caelum Eats")
                .setSubject(Long.toString(user.getId()))
                .claim("roles", user.getRoles())
                .claim("username", user.getUsername())
                .setIssuedAt(now)       .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, this.secret)
                .compact();
    }

}
