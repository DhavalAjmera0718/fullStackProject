package com.EMPLOYEEAUTH.Repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.EMPLOYEEAUTH.Entity.Emp_Credential;

@Repository
public interface AUTH_REPO extends JpaRepository<Emp_Credential,String> {

	
	Emp_Credential findByEmailAndDob(String email,LocalDate dob);
	
	Emp_Credential findByEmail(String email);
	
	Emp_Credential findByEmailAndOtpAndDob(String email , Integer otp,LocalDate date);
	
}
