package com.EMPLOYEEAUTH.Request_X_Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JWT_Request {

	private String username;
	
	private String password;
	
	
}
