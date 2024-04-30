package com.EMPLOYEE_SERVICE.Implimentation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.EMPLOYEE_SERVICE.DTOO.EMP_DTO;
import com.EMPLOYEE_SERVICE.Entity.EMP_ENTITY;
import com.EMPLOYEE_SERVICE.Helper.CONVERTER_HELPER_EMP;
import com.EMPLOYEE_SERVICE.Repository.EMP_REPO;
import com.EMPLOYEE_SERVICE.Service.EMP_SERVICE;

@Component
public class EMPLOYEE_IMPLIMANTATION implements EMP_SERVICE{

	
	@Autowired
	private EMP_REPO empRepo;
	
	@Autowired
	private CONVERTER_HELPER_EMP helper;
	
	@Override
	public String SaveEmpoyee_Data(EMP_DTO dto) {
		
		System.err.println("Response in DTO" + dto);
		EMP_ENTITY enityData = helper.ConvertEntityTo_Dto(dto);
		System.err.println("Entity Data-----> " + enityData);
		empRepo.save(enityData);
		return "Employee Data Hase Been Saved";
		
	}
	
	@Override
	public List<EMP_DTO> GetAll_EmpData()
	{
		List<EMP_ENTITY> EntityData = empRepo.findAll();
		List<EMP_DTO> dummyList = new ArrayList<>();
		for (EMP_ENTITY emp_ENTITY : EntityData) {
			
			EMP_DTO convertDTO_Entity = helper.convertDTO_Entity(emp_ENTITY);
			dummyList.add(convertDTO_Entity);
		}
		return dummyList;
	}
	
/***********************************************************[UPDATE EMPLOYEE BY ID]*******************************************************************************************************/
	public String UpdateEmp_ById(String idLong  , EMP_DTO dto) 
	{
		Optional<EMP_ENTITY> byId = empRepo.findById(idLong);
		
		if (byId!=null) {
			
			EMP_ENTITY emp_Entity_Data = byId.get();
			emp_Entity_Data.setEmpName(dto.getEmpName());
			emp_Entity_Data.setCity(dto.getCity());
			emp_Entity_Data.setContact(dto.getContact());
			emp_Entity_Data.setAchivements(dto.getAchivements());
			emp_Entity_Data.setEmail(dto.getEmail());
			emp_Entity_Data.setImage(dto.getImage());
			empRepo.save(emp_Entity_Data);
			return "Id Nuber " + idLong + " Has Been Updated..";
			
		}
		else {
			return "Please Enter valid Id";
		}
	}
/************************************************************[ Get DATA BY ID ]*****************************************************************************/

	public EMP_DTO getEmpDataBy_Id(String email) 
	{
		EMP_ENTITY emp_ENTITY = empRepo.findById(email).get();
		EMP_DTO convertDTO_Entity = helper.convertDTO_Entity(emp_ENTITY);
		return convertDTO_Entity;
	}
/************************************************************[ Delete DATA BY ID ]*****************************************************************************/
	public String deleteEmpDataBy_id(String email) 
	{
		
		empRepo.deleteById(email);
		return "Data hase Been Deleted";
	}



}
