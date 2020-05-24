/**
 * 
 */
package com.cruize.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cruize.booking.model.Booking;

/**
 * @author kvishal
 *
 */
public interface CruizeBookingRepository extends JpaRepository<Booking, Integer> {

}
