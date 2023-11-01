package com.phone.utils;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.crypto.SecretKey;
import java.security.Key;

@Component
public class JwtUtilsHelper {

    @Value("${jwt.privateKey}")
    private String privateKey;

    public String generateToken(String data){

        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        String jws = Jwts.builder().setSubject(data).signWith(key).compact();
        return jws;
    }

    public boolean verifyToken(String token){
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            return true;
        }catch(Exception e){
            return false;
        }
    }
}
