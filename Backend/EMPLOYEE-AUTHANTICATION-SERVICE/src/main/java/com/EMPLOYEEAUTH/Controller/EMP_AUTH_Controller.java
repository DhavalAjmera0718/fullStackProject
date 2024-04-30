package com.EMPLOYEEAUTH.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.EMPLOYEEAUTH.Entity.Emp_Credential;
import com.EMPLOYEEAUTH.Request_X_Response.JWT_Request;
import com.EMPLOYEEAUTH.Request_X_Response.JWT_Response;
import com.EMPLOYEEAUTH.Sevice.AUTH_SERVICE;

@RestController
public class EMP_AUTH_Controller {

	
	@Autowired
	private AUTH_SERVICE service;
	
	
	@PostMapping("/loginWithCred")
	public ResponseEntity<JWT_Response> loginWithCred(@RequestBody JWT_Request request)
	{
		return new ResponseEntity<JWT_Response>(service.loginWithCred(request),HttpStatus.CREATED);
	}
	
/***********************************************[REGISTER ADMIN ]*****************************************************************************/	
	@PostMapping("/RegisterEmployee")
	public ResponseEntity<String> RegisterEmployee(@RequestBody Emp_Credential entity) 
	{
		return new ResponseEntity<String>(service.RegisterEmployee(entity),HttpStatus.CREATED);
	}
/***********************************************[REGISTER ADMIN ]*****************************************************************************/	
	@PostMapping("/registeradmin")
	public ResponseEntity<String> RegisterAdmin(@RequestBody Emp_Credential entity) 
	{
		return new ResponseEntity<String>(service.RegisterAdmin(entity),HttpStatus.CREATED);
	}
		
	
	@PostMapping("/validate")
	public ResponseEntity<Boolean> ValidateToken()
	
	{
		return ResponseEntity.ok(true);
	}	
	
	/********************************************************[ UPDATE PASSWORD ]***********************************************************************************/	

	@PostMapping("/updatepass/{pass}")
	public ResponseEntity<String> UpdatePassword(@PathVariable("pass") String name,@RequestBody String entity ) 
	{
		return new ResponseEntity<String>(service.updatePasswordBy_Email(name, entity) , HttpStatus.ACCEPTED);
	}
	
	
	
}
