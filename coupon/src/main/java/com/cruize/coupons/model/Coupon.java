package com.cruize.coupons.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Coupon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int coupon_id;
	
	public int getCoupon_id() {
		return coupon_id;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date validDate;
	
	private int discountAmount;

	public Coupon(String validDate, int discountAmount) {
		super();
		this.discountAmount = discountAmount;
		setValidDate(validDate);
	}
	
	public Coupon() {
		super();
		
	}

	@Override
	public String toString() {
		return "Coupon [coupon_id=" + coupon_id + ", validDate=" + validDate + ", discountAmount=" + discountAmount
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + coupon_id;
		result = prime * result + discountAmount;
		result = prime * result + ((validDate == null) ? 0 : validDate.hashCode());
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
		Coupon other = (Coupon) obj;
		if (coupon_id != other.coupon_id)
			return false;
		if (discountAmount != other.discountAmount)
			return false;
		if (validDate == null) {
			if (other.validDate != null)
				return false;
		} else if (!validDate.equals(other.validDate))
			return false;
		return true;
	}

	public Date getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		Date date = new Date(System.currentTimeMillis());
		if (validDate!=null && this.validDate == null && (Date.valueOf(validDate).after(date))) {
			this.validDate = Date.valueOf(validDate);
		}
	}

	public int getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}

}
