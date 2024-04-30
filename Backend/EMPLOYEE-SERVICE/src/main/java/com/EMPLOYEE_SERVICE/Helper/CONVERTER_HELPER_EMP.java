package com.EMPLOYEE_SERVICE.Helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.EMPLOYEE_SERVICE.DTOO.EMP_DTO;
import com.EMPLOYEE_SERVICE.Entity.EMP_ENTITY;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CONVERTER_HELPER_EMP {
	
	@Autowired
	private ObjectMapper mapper;
	
	public EMP_ENTITY ConvertEntityTo_Dto(EMP_DTO emp_DTO) {
		
		return mapper.convertValue(emp_DTO, EMP_ENTITY.class);
	}
	public EMP_DTO convertDTO_Entity(EMP_ENTITY emp_ENTITY) {
		
		return mapper.convertValue(emp_ENTITY, EMP_DTO.class);
	}


}
