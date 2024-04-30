package com.EMPLOYEE_SERVICE.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Table( name = "service_Employee")
public class EMP_ENTITY {
	
	

	
	private String empId;
	
	@Id
	private String email;

	private String image;
	
	private String empName;
	
	private String contact;
	
	private String city;
	
	private String achivements;

}
