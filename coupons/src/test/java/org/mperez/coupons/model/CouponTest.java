package org.mperez.coupons.model;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.mperez.coupons.factory.CouponsFactory;

public class CouponTest {

	@Test
	public void createCoupon() {
		Coupon coupon = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 1000);
		assertTrue(new Float(1000).equals(coupon.getAmount()));
		assertTrue(5 == coupon.getItemIds().size());
	}

}
