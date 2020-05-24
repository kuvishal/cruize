package com.cruize.booking.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cruize.booking.model.Booking;
import com.cruize.booking.repository.CruizeBookingRepository;

@Service
public class CruizeBookingService {
	
	@Autowired
	private CruizeBookingRepository bookingRepo;
	
	public Booking createBooking(@Valid Booking model) {
		return bookingRepo.save(model);
	}


	public List<Booking> findAll(Map<String, String> params) {

		if (params == null || params.isEmpty()) {
			return bookingRepo.findAll();
		} else {
			Iterator<String> iterator = params.keySet().iterator();
			Booking booking = new Booking();   
			while (iterator.hasNext()) {
				String key = iterator.next();
				String value = params.get(key);
				if (value != null) {
					switch (key) {
					case "emailId":
						booking.setEmailId(value);
						break;
					default:
						break;
					}
				}
			}
			
			ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase()
					.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnorePaths("booking_id")
					.withIgnoreNullValues();
			Example<Booking> ex = Example.of(booking, matcher);
			
			List<Booking> resultList = bookingRepo.findAll(ex);
			if (resultList == null || resultList.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("No Booking!"));
			} else {
				return resultList;
			}
		}
	
	}

	public Booking getBookingById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
