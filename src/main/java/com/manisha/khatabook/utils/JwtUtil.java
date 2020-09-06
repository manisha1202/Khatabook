package com.manisha.khatabook.utils;

import com.manisha.khatabook.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

//import org.springframework.security.core.userdetails.UserDetails;

@Service
public final class JwtUtil {

    private static String SECRET_KEY = "secret";
    private static Long EXPIRATION_TIME = 1000 * 60 * 60 * 10l;

    private JwtUtil() {

    }

    public static String extractPhoneNumber(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public static Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private static Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    private static Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public static String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, user.getPhone_number());
    }

    private static String createToken(Map<String, Object> claims, String subject) {

        return Jwts.builder().setClaims(claims).setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }

    public static Boolean validateToken(String token, User user) {
        final String phone_number = extractPhoneNumber(token);
        return (phone_number.equals(user.getPhone_number()) && !isTokenExpired(token));
    }
}
