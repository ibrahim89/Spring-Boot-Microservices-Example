package com.myhome.departmentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.departmentservice.entity.Department;
import com.myhome.departmentservice.repo.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	
	public Department saveDepartment(Department department) {
		
	//log.info("saveDpeartment method of DepartmentService");
		return departmentRepository.save(department);
	}


	public Department findByDepartmentId(Long departmentId) {
		return departmentRepository.findByDepartmentId(departmentId);
	}


	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}
	
	
}
