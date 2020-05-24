package com.cruize.coupons.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.cruize.coupons.dto.CouponDTO;
import com.cruize.coupons.model.Coupon;
import com.cruize.coupons.repo.CouponRepository;

@Service
public class CouponService {

	private static final String COUPON_NOT_EXIST = "Coupon doesn't exist!";

	@Autowired
	private CouponRepository couponRepo;

	public List<Coupon> findAll(Map<String, String> params) {
		return couponRepo.findAll(new Specification<Coupon>() {

			@Override
			public Predicate toPredicate(Root<Coupon> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				Predicate p = builder.conjunction();
				p = builder.and(p, builder.greaterThanOrEqualTo(root.get("validDate"), Date.valueOf(LocalDate.now())));
				return p;
			}
		}

		);
	}

	public Coupon getCouponById(Integer id) {
		return couponRepo.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(COUPON_NOT_EXIST)));
	}

	public String removeCoupon(Integer id) {
		Optional<Coupon> trip = couponRepo.findById(id);
		if (trip.isPresent()) {
			couponRepo.deleteById(id);
			return "Deleted the coupon";
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(COUPON_NOT_EXIST));
		}
	}

	public Coupon createCoupon(@Valid  CouponDTO couponDTO) {
		Coupon coupon = new Coupon(couponDTO.getValidDate(), couponDTO.getDiscountAmount());
		return couponRepo.saveAndFlush(coupon);
	}

	public void updateCoupon(Integer id, CouponDTO coupon) {
		Optional<Coupon> couponOptional = couponRepo.findById(id);

		Coupon couponPresent = couponOptional
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format(COUPON_NOT_EXIST)));

		couponPresent.setDiscountAmount(coupon.getDiscountAmount());
		couponPresent.setValidDate(coupon.getValidDate());
		couponRepo.saveAndFlush(couponPresent);

	}

}
