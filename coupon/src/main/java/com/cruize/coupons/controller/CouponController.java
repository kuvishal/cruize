package com.cruize.coupons.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cruize.coupons.dto.CouponDTO;
import com.cruize.coupons.model.Coupon;
import com.cruize.coupons.service.CouponService;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

	

	@Autowired
 	private CouponService couponservice;

	@GetMapping("")
    @ResponseStatus(code= HttpStatus.OK)
    public List<Coupon> findAll(@RequestParam Map<String, String> params){
        return couponservice.findAll(params);
    }
	  

	@GetMapping("/{coupon_id}")
    @ResponseStatus(code= HttpStatus.OK)
    public Coupon getTrip(@PathVariable("coupon_id") Integer id) {
		return couponservice.getCouponById(id);
    }
	
	@DeleteMapping("/{coupon_id}")
    @ResponseStatus(code= HttpStatus.OK)
    public String removeCoupon(@PathVariable("coupon_id") Integer id) {
        return couponservice.removeCoupon(id);
    }
	
	

    @PostMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Coupon createUser(@RequestBody @Valid CouponDTO coupon) {
        return couponservice.createCoupon(coupon);
    }

    @PutMapping(value="/{coupon_id}" )
    @ResponseStatus(HttpStatus.OK)
    public void updateCoupon(@PathVariable("coupon_id") Integer id,
            @RequestBody CouponDTO coupon) {
        couponservice.updateCoupon(id,coupon);
    }

    
	@GetMapping("/health-status")
	public String healthStatus(){
		return "Coupon  Service UP and RUNNING";
		
	}
}
