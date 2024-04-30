package com.EMPLOYEE_SERVICE.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.EMPLOYEE_SERVICE.DTOO.EMP_DTO;

@Service
public interface EMP_SERVICE {

	public String SaveEmpoyee_Data(EMP_DTO dto) ;
	
	public List<EMP_DTO> GetAll_EmpData();
	
	public String UpdateEmp_ById(String idLong  , EMP_DTO dto);
	
	public EMP_DTO getEmpDataBy_Id(String email);
	
	
	public String deleteEmpDataBy_id(String email) ;
	
}
