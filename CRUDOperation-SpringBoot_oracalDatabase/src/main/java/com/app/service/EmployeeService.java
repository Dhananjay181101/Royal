package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Employee;
import com.app.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
		EmployeeRepo repo;
	
	public List<Employee> getemployeeById(int eid) {
		return repo.findByEid(eid);
	}
	
	
	
	
}
