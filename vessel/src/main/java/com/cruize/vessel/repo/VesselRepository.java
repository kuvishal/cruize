package com.cruize.vessel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cruize.vessel.model.Vessel;

public interface VesselRepository extends JpaRepository<Vessel, Integer> {
	
	

}
