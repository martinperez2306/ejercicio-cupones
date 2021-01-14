package org.mperez.coupons.service;

import java.util.HashMap;
import java.util.Map;

import org.mperez.coupons.adapter.CouponAdapter;
import org.mperez.coupons.calculation.ItemsCalculation;
import org.mperez.coupons.model.Coupon;
import org.mperez.coupons.rest.model.CouponInput;
import org.mperez.coupons.rest.model.CouponResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponDefaultService implements CouponService {
	
	@Autowired
	private ItemsCalculation itemsCalculation;
	
	@Autowired
	private CouponAdapter couponAdapter;

	@Override
	public CouponResponse getItemsForCoupon(CouponInput couponInput) {
		Coupon coupon = couponAdapter.adaptToModel(couponInput);
		Map<String, Float> items = new HashMap<String, Float>();
		itemsCalculation.calculate(items, coupon.getAmount());
		return null;
	}

}
