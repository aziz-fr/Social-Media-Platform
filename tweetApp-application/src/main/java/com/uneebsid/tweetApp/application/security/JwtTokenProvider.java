package com.uneebsid.tweetApp.application.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider
{
    @Value("${app.jwt-secret}")
    private String jwtSecret;

    private Long jwtExpirationDate = 604800L;


    public String generateToken(Authentication authentication)
    {
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);
        String token = Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(expireDate)
                .signWith(key())
                .compact();
        return token;
    }

    private Key key()
    {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String getUsername(String token)
    {
        return Jwts.parser()
                .verifyWith((SecretKey) key())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean validateToken(String token)
    {
        try {
            Jwts.parser()
                    .verifyWith((SecretKey) key())
                    .build()
                    .parse(token);
            return true;
        }
        catch (MalformedJwtException e)
        {
            throw new RuntimeException("Invalid jwt token");
        }
        catch (ExpiredJwtException e)
        {
            throw new RuntimeException("Expired JWT Token");
        }
        catch (UnsupportedJwtException e)
        {
            throw new RuntimeException("unsupported jwt token");
        }
        catch (IllegalArgumentException e)
        {
            throw new RuntimeException("Jwt Claims string is invalid or empty");
        }

    }

}
