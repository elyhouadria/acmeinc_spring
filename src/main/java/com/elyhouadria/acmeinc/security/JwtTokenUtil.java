package com.elyhouadria.acmeinc.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtTokenUtil {
    //Duration of token validity
    private static final long JWT_TOKEN_VALIDITY = 2 * 60 * 60 * 1000;
    //Secret used to crypt and sign JWT
    public static final String SECRET = "mysecret";


    private String token = null;

    //Utility to generate token
    private static JwtTokenUtil doGenerateToken(Map<String, Object> claims, String subject){

        String token = Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ JWT_TOKEN_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, SECRET).compact();

        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil(token);
        return jwtTokenUtil;

    }

    public JwtTokenUtil(String jwtToken) {
        this.token = jwtToken;
    }


    public String getUsernameFromToken() {
        return getClaimFromToken(Claims::getSubject);
    }


    public Date getExpirationDateFromToken() {
        return getClaimFromToken(Claims::getExpiration);
    }


    public <T> T getClaimFromToken(Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken();
        return claimsResolver.apply(claims);
    }


    public String getClaimFromTokenByName(String name) {
        final Claims claims = getAllClaimsFromToken();
        return (String)claims.get(name);
    }


    private Claims getAllClaimsFromToken() {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }


    private Boolean isTokenExpired() {
        final Date expiration = getExpirationDateFromToken();
        return expiration.before(new Date());
    }


    public static JwtTokenUtil generateToken(User user) {
        Map<String, Object> claims = addClaims(user);
        return doGenerateToken(claims, user.getUsername());
    }


    private static Map<String, Object> addClaims(User user) {
        Map<String, Object> claims = new HashMap<String, Object>();

        claims.put("id", user.getId());

        return claims;
    }



    public Boolean validateToken(UserDetails userDetails) {
        final String username = getUsernameFromToken();
        return (username.equals(userDetails.getUsername()) && !isTokenExpired());
    }

    public Boolean validateToken() {
        return (!isTokenExpired());
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
