package org.mperez.coupons.factory;

import java.util.List;

import org.mperez.coupons.model.Coupon;

public class CouponsFactory {
	
	public static Coupon createCoupon(List<String> itemIds, Float amount) {
		return new Coupon(itemIds, amount);
	}
	
	public static Coupon createCoupon(List<String> itemIds, Integer amount) {
		Float amountFloat = new Float(amount);
		return createCoupon(itemIds, amountFloat);
	}

}
