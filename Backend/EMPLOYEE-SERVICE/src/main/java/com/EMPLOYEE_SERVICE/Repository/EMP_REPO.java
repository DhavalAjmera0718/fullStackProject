package com.EMPLOYEE_SERVICE.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EMPLOYEE_SERVICE.Entity.EMP_ENTITY;

@Repository
public interface EMP_REPO extends JpaRepository<EMP_ENTITY, String>{

}
