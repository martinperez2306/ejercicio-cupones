package org.mperez.coupons.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mperez.coupons.rest.model.CouponRequest;
import org.mperez.coupons.rest.model.CouponResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class CouponServiceTest {

	@Autowired
	private CouponService couponService;
	
	@Test
	public void getItemsForValidCouponShuouldReturnItems() {
		CouponRequest couponInput = new CouponRequest().itemIds(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5")).amount(new Float(500));
		CouponResponse expected = new CouponResponse();
		expected.itemIds(Arrays.asList("MLA1","MLA2","MLA4","MLA5")).total(new Float(480));
		
		CouponResponse obtained = couponService.getItemsForCoupon(couponInput);
		assertTrue(expected.getTotal().equals(obtained.getTotal()));
		assertTrue(expected.getItemIds().size() == obtained.getItemIds().size());
		assertEquals(expected, obtained);
	}

}
