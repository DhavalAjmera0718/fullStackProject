package com.EMPLOYEEAUTH.Implimantation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.EMPLOYEEAUTH.Entity.Emp_Credential;
import com.EMPLOYEEAUTH.Helper.AUTH_JWT_HELPER;
import com.EMPLOYEEAUTH.Repository.AUTH_REPO;
import com.EMPLOYEEAUTH.Request_X_Response.JWT_Request;
import com.EMPLOYEEAUTH.Request_X_Response.JWT_Response;
import com.EMPLOYEEAUTH.Sevice.AUTH_SERVICE;

@Component
public class EMP_AUTH_IMPLI implements AUTH_SERVICE {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AUTH_JWT_HELPER jwtUtils;
	
	@Autowired
	private AUTH_REPO repo;
	
	
	@Override
	public JWT_Response loginWithCred(JWT_Request request) 
	{
		
		if (request!=null) {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
			
		}
		UserDetails userByUsername = userDetailsService.loadUserByUsername(request.getUsername());
		String jwtToken = null;
		if (userByUsername!=null) {
			
			jwtToken = jwtUtils.generateToken(userByUsername);
			System.err.println("**** Token From EMP AUTH IMPLI *******"+jwtToken);
			
		}
		return new JWT_Response(jwtToken);
	}
	
	
	public String RegisterEmployee(Emp_Credential entity) 
	{
		entity.setRole("ROLE_USER");
		repo.save(entity);
		return "Employee Data Has Been Saved..!!";
	}

	public String RegisterAdmin(Emp_Credential entity) 
	{
		entity.setRole("ROLE_ADMIN");
		repo.save(entity);
		return "ADMIN Data Has Been Saved..!!";
	}
	
/******************************************************[ UPDATE PASSWORD ]*****************************************************************************/	
	
	public String updatePasswordBy_Email(String email , String newPass)
	{
		Optional<Emp_Credential> byId = repo.findById(email);
		if (byId !=null) {
			
			
			Emp_Credential emp_Credential = byId.get();
			emp_Credential.setPassword(newPass);
			repo.save(emp_Credential);
			return "Password Hase Been Changed";			
		}
		else {
			return "Please Re-Enter Password...!!" ; 
		}
	}
	
	
	
	
	
}
