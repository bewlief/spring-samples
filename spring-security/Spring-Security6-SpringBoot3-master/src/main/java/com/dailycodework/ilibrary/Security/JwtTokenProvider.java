package com.dailycodework.ilibrary.Security;

import com.dailycodework.ilibrary.exception.BookAPIException;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${app.jwt-secrete}")
    private String jwtSecrete;
    @Value("${app.jwt-expiration}")
    private long jwtExpirationDate;

//    let generate JWT token
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();

        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + jwtExpirationDate);
        String token = Jwts.builder().setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(expireDate)
                .signWith(key())
                .compact();
        return token;
    }

//    decoding jwt secrete key
    private Key key() {
        return Keys.hmacShaKeyFor(
                Decoders.BASE64.decode(jwtSecrete)
        );
    }

//    Get username from JWT Token
    public String getUsername(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(key()).build()
                .parseClaimsJws(token).getBody();

        String username = claims.getSubject();
        return username;
    }

//    validate token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(token);
            return true;
        }catch (MalformedJwtException ex) {
            throw new BookAPIException("Invalid token", HttpStatus.BAD_REQUEST);
        }catch (ExpiredJwtException ex){
            throw new BookAPIException("Expired token", HttpStatus.BAD_REQUEST);
        }catch (UnsupportedJwtException ex) {
            throw new BookAPIException("Unsupported token", HttpStatus.BAD_REQUEST);
        }catch (IllegalArgumentException ex) {
            throw new BookAPIException("JWT claims string is empty", HttpStatus.BAD_REQUEST);
        }
    }

}
