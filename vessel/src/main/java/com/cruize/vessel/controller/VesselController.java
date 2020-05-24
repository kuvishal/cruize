package com.cruize.vessel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cruize.vessel.dto.VesselDTO;
import com.cruize.vessel.model.Vessel;
import com.cruize.vessel.service.VesselService;

@RestController
@RequestMapping("/api/vessel")
public class VesselController {

	@Autowired
	private VesselService service;

	@PostMapping("")
	@ResponseStatus(HttpStatus.OK)
	public void createVessel(@RequestBody @Valid VesselDTO vessel) {
		service.createVessel(vessel);
	}

	@GetMapping("/{vesselId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Vessel getVessel(@PathVariable("vesselId") int id) {
		return service.getVesselbyId(id);
	}
	
	@GetMapping("/health-status")
	public String healthStatus(){
		return "Vessel Service UP and RUNNING";
		
	}
}
