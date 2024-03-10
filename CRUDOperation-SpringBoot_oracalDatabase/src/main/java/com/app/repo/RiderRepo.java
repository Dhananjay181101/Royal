package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.app.model.Rider;
@Repository
public interface RiderRepo extends JpaRepository<Rider, Integer> {

	List<Rider> findByPersonid(int personid);
	
	
	
	
	
}
