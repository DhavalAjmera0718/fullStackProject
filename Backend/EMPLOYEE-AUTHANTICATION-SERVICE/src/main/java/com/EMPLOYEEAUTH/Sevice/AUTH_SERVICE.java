package com.EMPLOYEEAUTH.Sevice;

import org.springframework.stereotype.Service;

import com.EMPLOYEEAUTH.Entity.Emp_Credential;
import com.EMPLOYEEAUTH.Request_X_Response.JWT_Request;
import com.EMPLOYEEAUTH.Request_X_Response.JWT_Response;

@Service
public interface AUTH_SERVICE {
	
	public JWT_Response loginWithCred(JWT_Request request) ;
	public String RegisterEmployee(Emp_Credential entity) ;
	public String RegisterAdmin(Emp_Credential entity) ;
	
//	public String updatePasswordBy_Email(String email , Emp_Credential newPass);
	public String updatePasswordBy_Email(String email , String newPass);
	
	
	

}
