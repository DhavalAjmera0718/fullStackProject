package com.EMPLOYEEAUTH.Configuaration;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.EMPLOYEEAUTH.Entity.Emp_Credential;
import com.EMPLOYEEAUTH.Repository.AUTH_REPO;

@Configuration
public class AUTH_UserDetail_Configuaration implements UserDetailsService {

	
	
	@Autowired
	private AUTH_REPO repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Emp_Credential> CredEntity = repo.findById(username);
		if (CredEntity.isPresent()) {
			
			Emp_Credential emp_Credential = CredEntity.get();
			return new User(emp_Credential.getName() ,
					passwordEncoder().encode(emp_Credential.getPassword())
					,getAuthorities(emp_Credential.getRole()));
		}
		
		throw new UsernameNotFoundException("Username " + username + " is Invalid..!!  ");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() 
	{
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration builder) throws Exception {
		return builder.getAuthenticationManager();
	}
	
	
	private Collection<? extends GrantedAuthority> getAuthorities(String role) {
		return Collections.singletonList(new SimpleGrantedAuthority(role));
	}

	
	
}
