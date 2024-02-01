package org.example.wimelody.config;

import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.example.wimelody.dto.user.UserDtoRsp;
import org.example.wimelody.entities.Admin;
import org.example.wimelody.entities.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import  com.auth0.jwt.JWT;

import java.time.Instant;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class UserAuthProvider {

    @Value("${jwt.secret-key}")
    private  String secretKey;

    @PostConstruct
    public void init(){
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public  String createToken(UserDtoRsp userCredential){
        Date expirationDate = Date.from(Instant.now().plusMillis(86400000));
        return JWT.create()
                .withIssuer(userCredential.getEmail())
                .withIssuedAt(Instant.now())
                .withExpiresAt(expirationDate)
                .withClaim("username", userCredential.getUsername())
                .sign(com.auth0.jwt.algorithms.Algorithm.HMAC256(secretKey));
    }

    public Authentication getAuthentication(String token){
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm).build();

        DecodedJWT decodedJWT = verifier.verify(token);

        Person person = new Admin();
        person.setEmail(decodedJWT.getIssuer());
        person.setUsername(decodedJWT.getClaim("username").asString());

        return new UsernamePasswordAuthenticationToken(person, null, Collections.emptyList());


    }
}
