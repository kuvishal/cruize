package com.cruize.vessel;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cruize.vessel.model.Vessel;
import com.cruize.vessel.repo.VesselRepository;

@Component
public class MyRunner implements CommandLineRunner {

	@Autowired
	private VesselRepository vesselRepo;
	@Override
	public void run(String... args) throws Exception {
		
		ArrayList<Vessel> vesselArr = new ArrayList();
		vesselArr.add(new Vessel("Beauty Queen", "2011-06-01"));
		vesselArr.add(new Vessel("Sea Queen", "2012-10-01"));
		vesselArr.add(new Vessel("Aqua Blaze", "2009-07-15"));
		vesselArr.add(new Vessel("Coast 2 Coast", "2010-03-12"));
		
		vesselRepo.saveAll(vesselArr);

	}

}
