package com.springboot.filter;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import com.springboot.exception.JwtAuthenticationException;
import com.springboot.service.JwtService;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{
	private JwtService jwtService;
	  private final HandlerExceptionResolver handlerExceptionResolver;
	public JwtFilter(JwtService jwtService,
			HandlerExceptionResolver handlerExceptionResolver) {
		this.jwtService = jwtService;
		this.handlerExceptionResolver = handlerExceptionResolver;
	}
	
	@Override
	public void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain) throws IOException,ServletException{
	try {		
		String token = request.getHeader("Authorization");
		if(token!=null && token.startsWith("Bearer ")) {
			
			String receivedToken = token.substring(7);
//			String receivedToken = token.substring(7).split(",")[0].trim();

			Claims claim = jwtService.validateToken(receivedToken);
			String email = claim.getSubject();
		 	String role = claim.get("role", String.class);
		 	
		 	String path = request.getRequestURI();
		 	
		 	if (path.startsWith("/admin") && !role.equalsIgnoreCase("ADMIN")) {
		 	    throw new JwtAuthenticationException("Invalid token for ADMIN resource");
		 	}

		 	if (path.startsWith("/user") && !role.equalsIgnoreCase("USER")) {
		 	    throw new JwtAuthenticationException("Invalid token for USER resource");
		 	}
		 	
		 	
		 	UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
		 			email,
		 			null,
		 			List.of(new SimpleGrantedAuthority("ROLE_"+role.toUpperCase()))
		 	);
		 	
		 	SecurityContextHolder.getContext().setAuthentication(auth);
		}
		chain.doFilter(request, response);
	 } catch (Exception ex) {

		 handlerExceptionResolver.resolveException(request, response, null, ex);
		 // here null represents that we are not inside any controller which have route or method
		 return;
	    }
	}
	  // Skip filter for public endpoints
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return path.startsWith("/auth")
                || path.startsWith("/register")
                || path.startsWith("/login");
    }
}
