package com.EMPLOYEE_SERVICE.DTOO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class EMP_DTO {

	private String empId;
	
	private String email;

	private String image;
	
	private String empName;
	
	private String contact;
	
	private String city;
	
	
	private String achivements;
}
