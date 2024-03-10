package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Employee;
import com.app.model.Rider;
import com.app.repo.RiderRepo;

@Service
public class RiderService {
@Autowired
private RiderRepo repo;


public List<Rider> getriderById(int personid) {
	return repo.findByPersonid(personid);
}




}
