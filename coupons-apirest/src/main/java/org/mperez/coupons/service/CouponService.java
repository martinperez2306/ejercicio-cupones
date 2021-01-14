package org.mperez.coupons.service;

import org.mperez.coupons.rest.model.CouponInput;
import org.mperez.coupons.rest.model.CouponResponse;

public interface CouponService {
	
	public CouponResponse getItemsForCoupon(CouponInput couponInput);

}
