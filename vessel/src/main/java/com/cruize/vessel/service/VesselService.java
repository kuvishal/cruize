package com.cruize.vessel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cruize.vessel.dto.VesselDTO;
import com.cruize.vessel.model.Vessel;
import com.cruize.vessel.repo.VesselRepository;

@Service
public class VesselService {

	@Autowired
	private VesselRepository repo;

	public void createVessel(VesselDTO dto) {
		Vessel vessel = new Vessel(dto.getName(), dto.getDate());
		repo.save(vessel);
	}

	public Vessel getVesselbyId(int id) {
		return repo.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Vessel doesn't exist!")));
	}

}
