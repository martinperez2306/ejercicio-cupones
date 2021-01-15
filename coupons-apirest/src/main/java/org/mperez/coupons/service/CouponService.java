package org.mperez.coupons.service;

import org.mperez.coupons.rest.model.CouponRequest;
import org.mperez.coupons.rest.model.CouponResponse;

public interface CouponService {
	
	public CouponResponse getItemsForCoupon(CouponRequest couponInput);

}
