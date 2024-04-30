package com.EMPLOYEEAPI_GETWAY;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EmployeeApiGetWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApiGetWayApplication.class, args);
	}

}
