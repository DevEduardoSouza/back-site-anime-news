package com.anime.news.security;


import com.anime.news.entities.UserEntity;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.tokek.secret}")
    private String secrete;

    public String generateToken(UserEntity user){
        try{
            Algorithm algorithm =  Algorithm.HMAC256(secrete);
            String token = JWT.create()
                    .withIssuer("api-news")
                    .withSubject(user.getEmail())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);
            return token;
        }catch (JWTCreationException exception){
            throw new RuntimeException("Error ao gerar o token", exception);
        }

    }

    public String validateToken(String token){
        try{
            Algorithm algorithm =  Algorithm.HMAC256(secrete);
            return JWT.require(algorithm)
                    .withIssuer("api-news")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            return "";
        }
    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
