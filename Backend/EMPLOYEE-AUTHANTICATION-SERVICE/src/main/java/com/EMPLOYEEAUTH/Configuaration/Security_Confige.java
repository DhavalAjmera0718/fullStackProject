package com.EMPLOYEEAUTH.Configuaration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.EMPLOYEEAUTH.Exception.JWT_Entrypoint;
import com.EMPLOYEEAUTH.Filter.JWT_FILTER;

@Configuration
public class Security_Confige {
	
	
	@Autowired
	private JWT_Entrypoint entrypoint;
	
	@Autowired
	private JWT_FILTER filter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.cors(co-> co.disable())
					.csrf(cs-> cs.disable())
					.authorizeHttpRequests(req-> 
					req.requestMatchers("sendotp/**","/verifyotp/**" ,"/updatepass/**", "/getLink/**" , "/RegisterEmployee","/loginWithCred","/emp/GetAllEmp_Data","/registeradmin/**" , "/GetAllEmp_Data").permitAll()
					.requestMatchers("/emp/**").hasRole("ADMIN")
					.anyRequest()
					.authenticated())
					.exceptionHandling(ex -> ex.authenticationEntryPoint(entrypoint))
					.sessionManagement(s-> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		httpSecurity.addFilterBefore(filter , UsernamePasswordAuthenticationFilter.class);
					
		return httpSecurity.build();
	}

}
