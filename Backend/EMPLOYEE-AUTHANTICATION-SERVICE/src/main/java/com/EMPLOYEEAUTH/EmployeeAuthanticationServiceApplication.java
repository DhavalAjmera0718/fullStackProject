package com.EMPLOYEEAUTH;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeAuthanticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeAuthanticationServiceApplication.class, args);
	}

}
