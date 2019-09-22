package com.paradecision.config;

import com.paradecision.organizations.users.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${paradecision.jwt.expiration}")
    private String expiration;

    @Value("${paradecision.jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {



        User user = (User) authentication.getPrincipal();

        Date date = new Date();
        Date expirationDate = new Date(date.getTime()+expiration);

        return Jwts.builder()
                .setIssuer("ParaDecision API")
                .setSubject(user.getId().toString())
                .setIssuedAt(date)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }
}
