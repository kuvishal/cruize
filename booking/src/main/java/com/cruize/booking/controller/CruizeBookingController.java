package com.cruize.booking.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cruize.booking.model.Booking;
import com.cruize.booking.service.CruizeBookingService;

@RestController
@RequestMapping("/api/booking")
public class CruizeBookingController {

	@Autowired
	private Environment env;

	@Autowired
	private CruizeBookingService bookingService;
	
	@GetMapping("")
    @ResponseStatus(code= HttpStatus.OK)
    public List<Booking> findAll(@RequestParam Map<String, String> params){
        return bookingService.findAll(params);
    }
	  

	@GetMapping("/{bookingId}")
    @ResponseStatus(code= HttpStatus.OK)
    public Booking getBooking(@PathVariable("bookingId") Integer id) {
		return bookingService.getBookingById(id);
    }
	
	@DeleteMapping("/{bookingId}")
    @ResponseStatus(code= HttpStatus.OK)
    public String removeCoupon(@PathVariable("bookingId") Integer id) {
        return bookingService.removeBooking(id);
    }

	@PostMapping("")
	@ResponseStatus(HttpStatus.OK)
	public void createBooking(@RequestBody @Valid Booking booking) {
		bookingService.createBooking(booking);
		//updateSlotsBooking(booking);
	}
	

	  public void updateSlotsBooking(Booking booking) {
	        
	        RestTemplate restTemplate = new RestTemplate();
	        HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        HashMap<String, Integer> bodyparams = new HashMap<>();
	        bodyparams.put("vessel_itenoryId", booking.getVesselItrId());
	        bodyparams.put("avilablity", booking.getNumberOfPassenger());
	        HttpEntity<HashMap<String, Integer>> entity = new HttpEntity<>(bodyparams, headers);
	        restTemplate.exchange(env.getProperty("notification.service.url"), HttpMethod.PUT, entity, Void.class);

	    }


}
