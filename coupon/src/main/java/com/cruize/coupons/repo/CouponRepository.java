package com.cruize.coupons.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cruize.coupons.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> ,JpaSpecificationExecutor<Coupon>  {
	
	

}
