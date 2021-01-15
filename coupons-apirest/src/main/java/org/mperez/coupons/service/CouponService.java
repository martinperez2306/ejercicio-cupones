package org.mperez.coupons.service;

import org.mperez.coupons.model.Coupon;
import org.mperez.coupons.model.ItemsForCoupon;

public interface CouponService {
	
	public ItemsForCoupon getItemsForCoupon(Coupon coupon);

}
