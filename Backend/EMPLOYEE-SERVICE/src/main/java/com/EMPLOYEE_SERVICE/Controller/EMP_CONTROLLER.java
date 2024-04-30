package com.EMPLOYEE_SERVICE.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.EMPLOYEE_SERVICE.DTOO.EMP_DTO;
import com.EMPLOYEE_SERVICE.Service.EMP_SERVICE;

@RestController
public class EMP_CONTROLLER {

	
	@Autowired
	private EMP_SERVICE service;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@PostMapping("/SaveEmployee_Data")
	public ResponseEntity<String> SaveEmployee_Data(@RequestHeader("Authorization") String headerToken, @RequestBody EMP_DTO dto) {
		
		String value = headerToken;
		System.err.println(value);
		HttpHeaders headers=new HttpHeaders();
		headers.set("Authorization", value);
		System.err.println("*************");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> req = new HttpEntity<>(null, headers);
		
		Boolean postForEntity = restTemplate.postForObject("http://localhost:7002/auth/validate", req,  Boolean.class);
		System.err.println("---------->]" + postForEntity);
		
		if(postForEntity==true) {
			String registerWithDetails = service.SaveEmpoyee_Data(dto);
			return new ResponseEntity<String>(registerWithDetails,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong!",HttpStatus.BAD_REQUEST);
	
	}
/**********************************************************************************************************************/

	@PostMapping("/update/{id}")
	public ResponseEntity<String> updatedummyapi(@RequestHeader("Authorization") String headerToken, @PathVariable("id") String idLong , @RequestBody EMP_DTO dto) {
		
		String value = headerToken;
		System.err.println(value);
		HttpHeaders headers=new HttpHeaders();
		headers.set("Authorization", value);
		System.err.println("*************");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> req = new HttpEntity<>(null, headers);
		
		Boolean postForEntity = restTemplate.postForObject("http://localhost:7002/auth/validate", req,  Boolean.class);
		System.err.println("---------->]" + postForEntity);
		
		if(postForEntity==true) {
			String registerWithDetails = service.UpdateEmp_ById(idLong , dto);
			return new ResponseEntity<String>(registerWithDetails,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong!",HttpStatus.BAD_REQUEST);
	
	}
	
	
/**********************************************************************************************************************/
	
	
	
	
	
	@GetMapping("/GetAllEmp_Data")
	public ResponseEntity<List<EMP_DTO>> GetAllEmp_Data(@RequestHeader("Authorization") String headerToken){
		
		String value = headerToken;
		System.err.println(value);
		HttpHeaders headers=new HttpHeaders();
		headers.set("Authorization", value);
		System.err.println("*************");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> req = new HttpEntity<>(null, headers);
		
		Boolean postForEntity = restTemplate.postForObject("http://localhost:7002/auth/validate", req,  Boolean.class);
		System.err.println("---------->]" + postForEntity);
		if (postForEntity) {			
			return new ResponseEntity<List<EMP_DTO>>(service.GetAll_EmpData() , HttpStatus.OK);
		}
		return new ResponseEntity<List<EMP_DTO>>(HttpStatus.BAD_REQUEST);
	}
	
/***********************************************************[UPDATE EMPLOYEE BY ID]*******************************************************************************************************/
	
	@PostMapping("/UpdateEmp_ById/{idLong}")
	public ResponseEntity<String> UpdateEmp_ById(@RequestHeader("Authorization") String headerToken, @PathVariable("idLong") String idLong  ,@RequestBody EMP_DTO dto) 
	{
		String value = headerToken;
		System.err.println(value);
		HttpHeaders headers=new HttpHeaders();
		headers.set("Authorization", value);
		System.err.println("*************");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<Object> req = new HttpEntity<>(null, headers);
		
		Boolean postForEntity = restTemplate.postForObject("http://localhost:7002/auth/validate", req,  Boolean.class);
		System.err.println("---------->]" + postForEntity);
					
		
		if (postForEntity==true)
		{			
			return new ResponseEntity<String>(service.UpdateEmp_ById(idLong, dto),HttpStatus.CREATED);
		}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	
/*****************************************************[ GET EMP DATA BY ID]****************************************************************************************/	
	@GetMapping("get-emp-byid/{email}")
	public ResponseEntity<EMP_DTO> getEmpDataBy_Id(@PathVariable("email") String email) 
		{
		System.err.println("EMail ---------->" + email);
			return new ResponseEntity<EMP_DTO>(service.getEmpDataBy_Id(email), HttpStatus.OK);
		}
	
/************************************************************[ Delete DATA BY ID ]*****************************************************************************/
	@GetMapping("delete-empdata-byid/{email}")
	public ResponseEntity<String> deleteEmpDataBy_id(@PathVariable("email") String email) 
	{
		return new ResponseEntity<String>( service.deleteEmpDataBy_id(email), HttpStatus.OK);
	}


}
