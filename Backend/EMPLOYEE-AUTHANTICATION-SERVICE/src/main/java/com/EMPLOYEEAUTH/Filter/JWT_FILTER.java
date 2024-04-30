package com.EMPLOYEEAUTH.Filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.EMPLOYEEAUTH.Configuaration.AUTH_UserDetail_Configuaration;
import com.EMPLOYEEAUTH.Helper.AUTH_JWT_HELPER;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWT_FILTER extends OncePerRequestFilter {
	
	
	@Autowired
	private AUTH_JWT_HELPER helper;

	
	@Autowired
	private AUTH_UserDetail_Configuaration userDetailsService;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
		
		String headerToken =  request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		System.err.println("headerToken From Filter----------------  " + headerToken);
		if(headerToken!=null && headerToken.startsWith("Bearer ") ) 
		{
			jwtToken =  headerToken.substring(7);
			System.err.println("JWTTOKEN From If in filter ----------" + jwtToken);
			
				
				username = helper.getUsernameFromToken(jwtToken);
				System.err.println("***** USER Name ****" + username);
			
			if (username!=null  && SecurityContextHolder.getContext().getAuthentication()==null)
			{
				UserDetails userByUsername = userDetailsService.loadUserByUsername(username);
				System.err.println("***** USER bY USER NAME ****" + userByUsername);
				if (helper.validateToken(jwtToken, userByUsername)) {
					
					UsernamePasswordAuthenticationToken authToken =
							new UsernamePasswordAuthenticationToken( username , null , userByUsername.getAuthorities());
					authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authToken);
				}
			
			}
		}
	}
		catch (Exception e) {
			logger.info("Some changed has done in token !! Invalid Token");
			e.printStackTrace();
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	
	
	

}
