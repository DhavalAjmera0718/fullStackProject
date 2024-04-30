package com.EMPLOYEEAUTH.Controller;

import java.time.LocalDate;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EMPLOYEEAUTH.Implimantation.Forgot_password_impli;

@RestController
public class Forgot_Password_Controller {
	
	
	@Autowired
	private Forgot_password_impli forgot_password_impli;
	
	@PostMapping("/sendotp/{email}/{dob}")
	public ResponseEntity<String> sendRandomOTP(@PathVariable("email") String email
			,@PathVariable("dob")  LocalDate dob) throws MessagingException {
		
		System.err.println("Email from Controller----->"+email);
		System.err.println("DOB from Controller----->"+dob);
	    return new ResponseEntity<String>(forgot_password_impli.sendRandomOTP(email, dob), HttpStatus.CREATED);
	}
/******************************************************* [ Verify OTP ] ******************************************************************************************************************/	
	
	@GetMapping("/verifyotp/{email}/{otp}/{dob}")
	public ResponseEntity<String> verifyOTP(@PathVariable("email") String email ,
			@PathVariable("otp") Integer otp 
			,@PathVariable("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dob  ) throws MessagingException 
	{
		return new ResponseEntity<>(forgot_password_impli.verifyOTP(email, otp, dob) , HttpStatus.CREATED);
	}
/******************************************************* [GET LINK FOR NEVIGATE TO UPDATE PASSWORD ] ******************************************************************************************************************/	
	
	@GetMapping("/getLink/{email}/{otp}/{dob}")
	public ResponseEntity<String> getLink(@PathVariable("email") String email ,
			@PathVariable("otp") Integer otp 
			,@PathVariable("dob") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dob  ) throws MessagingException 
	{
		return new ResponseEntity<>(forgot_password_impli.verifyOTP(email, otp, dob) , HttpStatus.CREATED);
	} 	
	
}
