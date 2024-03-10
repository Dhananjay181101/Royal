package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.repo.EmployeeRepo;
import com.app.service.EmployeeService;


@RestController
@CrossOrigin("http://localhost:3000")
public class EmployeeController {

	@Autowired
	private EmployeeRepo repo;
	@Autowired
	private EmployeeService service;
	
	@PostMapping ("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		try {
		repo.save(employee);
		}
		catch(Exception e) {
			return new ResponseEntity<String> ("not inserted", HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return new ResponseEntity<String> ("sucessfully inserted", HttpStatus.OK); 
		
	}
	@GetMapping ("/getAll")
	public ResponseEntity<List<Employee>> getEmployee(){
		List<Employee> list = null;
		try {
		list =   repo.findAll();
		}
		catch(Exception e) {
			return new ResponseEntity<List<Employee>> (list, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return new ResponseEntity<List<Employee>> (list, HttpStatus.OK); 
	
}
	
	@DeleteMapping ("/delete/{eid}")
	public ResponseEntity<String> getEmployee(@PathVariable("eid") int eid){
		
		try {
		   repo.deleteById(eid);
		}
		catch(Exception e) {
			return new ResponseEntity<> ("not deleted" , HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return new ResponseEntity<> ("successfully deleted", HttpStatus.OK); 
	
}
	
	
	@PutMapping("/update")
	public String updateEmp(@RequestBody Employee emp)
	{
		Optional<Employee> temp= repo.findById(emp.getEid());
		Employee employee=temp.get();
		//Swapping 
		employee.setName(emp.getName());
		employee.setSalery(emp.getSalery());
		repo.save(employee);
		return "successfully update";
	}
	

	@GetMapping("/getById/{eid}")
	
	public List<Employee> getById (@PathVariable int eid) {
		System.out.println("Show by id "+eid);
		List<Employee> appt= service.getemployeeById(eid);
		System.out.println("Got==="+appt);
		return appt;
	}

	

	
	
	
	
	
	
	
	
	
	
	
}