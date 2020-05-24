package com.cruize.vessel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.cruize.vessel.model.VesselItenaory;

@Repository
public interface VesselItenaoryRepository
		extends JpaRepository<VesselItenaory, Integer>, JpaSpecificationExecutor<VesselItenaory> {


}
