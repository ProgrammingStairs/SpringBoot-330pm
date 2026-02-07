package com.springboot.service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	public String SECRET = "qwertyuiopasdfghjk23456789zxcvb45678ertyuiqwe";
	public String generateToken(String email,String role) {
		Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
		return Jwts.builder()
			.setSubject(email)
			.addClaims(Map.of("role",role))
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis()+600000))
			.signWith(key, SignatureAlgorithm.HS256)
			.compact();
	}
	
	public Claims validateToken(String token) {
		Key key = Keys.hmacShaKeyFor(SECRET.getBytes());
		return Jwts.parserBuilder()
					.setSigningKey(key)
					.build()
					.parseClaimsJws(token)
					.getBody();
	}
	
	public String extractRole(String token) {
	    return validateToken(token).get("role", String.class);
	}

}
