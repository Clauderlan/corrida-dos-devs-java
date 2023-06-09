package com.c7.corrida.services.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.c7.corrida.entities.User;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String generatorToken(User user) {

        return JWT.create()
                .withIssuer("corrida")
                .withSubject(user.getUsername())
                .withClaim("id", user.getId())
                .withExpiresAt(LocalDateTime.now()
                        .plusMinutes(60L)
                        .toInstant(ZoneOffset.of("-03:00"))
                ).sign(Algorithm.HMAC256("secret"));
    }

    public String getSubject(String token) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("secret"))
                .withIssuer("corrida").build();
        DecodedJWT verify = jwtVerifier.verify(token);
        return verify.getSubject();
    }

}