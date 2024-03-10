package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Employee;
import com.app.model.Rider;
import com.app.repo.RiderRepo;
import com.app.service.RiderService;

@RestController

public class RiderController {

	@Autowired
	private RiderRepo repo;
	@Autowired
	private RiderService service;
	
	@PostMapping ("/saveRider")
	public ResponseEntity<String> saveRider(@RequestBody Rider rider){
		try {
		repo.save(rider);
		}
		catch(Exception e) {
			return new ResponseEntity<String> ("not inserted", HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return new ResponseEntity<String> ("sucessfully inserted", HttpStatus.OK); 
		
	}
	
	@GetMapping ("/getAllRider")
	public ResponseEntity<List<Rider>> getRider(){
		List<Rider> list = null;
		try {
		list =   repo.findAll();
		}
		catch(Exception e) {
			return new ResponseEntity<List<Rider>> (list, HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return new ResponseEntity<List<Rider>> (list, HttpStatus.OK); 
	
}

	
	@DeleteMapping ("/deleteRider/{personid}")
	public ResponseEntity<String> getRider(@PathVariable("personid") int personid){
		
		try {
		   repo.deleteById(personid);
		}
		catch(Exception e) {
			return new ResponseEntity<> ("not deleted" , HttpStatus.INTERNAL_SERVER_ERROR); 
		}
		return new ResponseEntity<> ("successfully deleted", HttpStatus.OK); 
	
}
	
	@PutMapping("/updateRider")
	public String updateRider(@RequestBody Rider Rider)
	{
		Optional<Rider> temp= repo.findById(Rider.getPersonid());
		Rider rider=temp.get();
		//Swapping 
		rider.setName(Rider.getName());
		rider.setEmail(Rider.getEmail());
		rider.setAge(Rider.getAge());
		rider.setCity(Rider.getCity());
		rider.setPassword(Rider.getPassword());
		rider.setPhoneno(Rider.getPhoneno());
		rider.setUserrole(Rider.getUserrole());
		rider.setUserName(Rider.getUserName());
		
		repo.save(Rider);
		return "successfully update";
	}
	
	
	

	@GetMapping("/getRiderById/{personid}")
	
	public List<Rider> getById (@PathVariable int personid) {
		System.out.println("Show by id "+personid);
		List<Rider> appt= service.getriderById(personid);
		System.out.println("Got==="+appt);
		return appt;
	}

	
	
	
	
	
	
	
}
