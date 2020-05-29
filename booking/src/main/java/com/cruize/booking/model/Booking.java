package com.cruize.booking.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int booking_id;
	
	private int cost;

	private int coupon_id;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date travel_date;

	private Date booking_date;

	private int numberOfPassenger;

	private String emailId;

	private int vesselItrId;

	private int discountAmount;
	
	private int finalCost;
	
	public Booking(int cost, int coupon_id, String travel_date, int numberOfPassenger, String emailId, int vesselItrId,
			int discountAmount) {
		super();
		this.cost = cost;
		this.coupon_id = coupon_id;
		this.travel_date = Date.valueOf(travel_date);
		this.numberOfPassenger = numberOfPassenger;
		this.emailId = emailId;
		this.vesselItrId = vesselItrId;
		this.discountAmount = discountAmount;
		this.finalCost= cost-discountAmount;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((booking_date == null) ? 0 : booking_date.hashCode());
		result = prime * result + booking_id;
		result = prime * result + cost;
		result = prime * result + coupon_id;
		result = prime * result + discountAmount;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + finalCost;
		result = prime * result + numberOfPassenger;
		result = prime * result + ((travel_date == null) ? 0 : travel_date.hashCode());
		result = prime * result + vesselItrId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		if (booking_date == null) {
			if (other.booking_date != null)
				return false;
		} else if (!booking_date.equals(other.booking_date))
			return false;
		if (booking_id != other.booking_id)
			return false;
		if (cost != other.cost)
			return false;
		if (coupon_id != other.coupon_id)
			return false;
		if (discountAmount != other.discountAmount)
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (finalCost != other.finalCost)
			return false;
		if (numberOfPassenger != other.numberOfPassenger)
			return false;
		if (travel_date == null) {
			if (other.travel_date != null)
				return false;
		} else if (!travel_date.equals(other.travel_date))
			return false;
		if (vesselItrId != other.vesselItrId)
			return false;
		return true;
	}


	public Booking() {
		super();
	}
	
	public int getBooking_id() {
		return booking_id;
	}

	public int getFinalCost() {
		return finalCost;
	}
	
	public void setFinalCost(){
		finalCost=cost-discountAmount;
	}
	public int getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}

	public int getVesselItrId() {
		return vesselItrId;
	}

	public void setVesselItrId(int vesselItrId) {
		this.vesselItrId = vesselItrId;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(int coupon_id) {
		this.coupon_id = coupon_id;
	}

	public Date getTravel_date() {
		return travel_date;
	}

	public void setTravel_date(String travel_date) {
		this.travel_date = Date.valueOf(travel_date);
	}

	public int getNumberOfPassenger() {
		return numberOfPassenger;
	}

	public void setNumberOfPassenger(int numberOfPassenger) {
		this.numberOfPassenger = numberOfPassenger;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getBooking_date() {
		return booking_date;
	}

	@PrePersist
	public void prePersist() {
		booking_date = (booking_date == null) ? Date.valueOf(LocalDate.now()) : booking_date;
	}

}
