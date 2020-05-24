package com.cruize.vessel.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cruize.vessel.dto.VesselItrDTO;
import com.cruize.vessel.model.VesselItenaory;
import com.cruize.vessel.service.VesselItenaoryService;

@RestController
@RequestMapping("/api/itenaory")
public class VesselItenaoryController {
 
	@Autowired
	private VesselItenaoryService service;
	
	@GetMapping("/search")
    @ResponseStatus(code= HttpStatus.OK)
    public List<VesselItenaory> findAll(@RequestParam Map<String, String> params){
        return service.findAll(params);
    }
	
	@GetMapping("/{itrId}")
    @ResponseStatus(code= HttpStatus.OK)
    public VesselItenaory findItr(@PathVariable("itrId") int id){
        return service.findItenaoryByID(id);
    }
	
	@PostMapping("")
	 @ResponseStatus(code= HttpStatus.OK)
	public void createItenaory(@RequestBody @Valid VesselItrDTO itenaory) {
		service.createItenaory(itenaory);
	}
	
	@PutMapping(path="/updateslots",
			consumes={MediaType.APPLICATION_JSON_VALUE})
	public String updateSlots(
             @RequestBody HashMap<String, Integer> params) {
		return service.decrementAvialablity(params);
    }
}
