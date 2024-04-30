package com.EMPLOYEEAUTH.Entity;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp_Credential {
	
	@Id
	private String name;
	
	private String password;
	
	private String email;
	
	private String role;
	
	private LocalDate dob;
	
	private Integer otp;
	
	@CreationTimestamp
	private Date createdTime;
	
	private String url;

}
