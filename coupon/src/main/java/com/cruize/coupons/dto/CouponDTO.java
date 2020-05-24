package com.cruize.coupons.dto;

public class CouponDTO {

	private String validDate;
	
	private int discountAmount;

	public CouponDTO(String validDate, int discountAmount) {
		this.discountAmount = discountAmount;
		this.validDate= validDate;
	}
	
	 public CouponDTO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CouponDTO [validDate=" + validDate + ", discountAmount=" + discountAmount + "]";
	}

	public String getValidDate() {
		return validDate;
	}

	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}

	public int getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(int discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		CouponDTO other = (CouponDTO) obj;
		if (discountAmount != other.discountAmount)
			return false;
		if (validDate == null) {
			if (other.validDate != null)
				return false;
		} else if (!validDate.equals(other.validDate))
			return false;
		return true;
	}
}
