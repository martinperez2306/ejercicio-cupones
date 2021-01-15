package org.mperez.coupons.adapter;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mperez.coupons.factory.CouponsFactory;
import org.mperez.coupons.model.Coupon;
import org.mperez.coupons.rest.model.CouponRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class CouponAdapterTest {
	
	@Autowired
	private CouponAdapter couponAdapter;
	
	@Test
	public void adaptToViewShouldCreateExpectedViewObject() {
		CouponRequest expected = new CouponRequest();
		expected.setAmount(new Float(100));
		expected.setItemIds(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"));
		
		Coupon example = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 100);
		
		CouponRequest adapted = couponAdapter.adaptToView(example);
		
		assertTrue(expected.getAmount().equals(adapted.getAmount()));
		assertTrue(expected.getItemIds().get(0).equals(adapted.getItemIds().get(0)));
		assertTrue(expected.getItemIds().get(1).equals(adapted.getItemIds().get(1)));
		assertTrue(expected.getItemIds().get(2).equals(adapted.getItemIds().get(2)));
		assertTrue(expected.getItemIds().get(3).equals(adapted.getItemIds().get(3)));
		assertTrue(expected.getItemIds().get(4).equals(adapted.getItemIds().get(4)));
	}
	
	@Test
	public void adaptToModelShouldCreateExpectedModelObject() {
		Coupon expected = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 100);
		
		CouponRequest example = new CouponRequest();
		example.setAmount(new Float(100));
		example.setItemIds(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"));
		
		Coupon adapted = couponAdapter.adaptToModel(example);
		
		assertTrue(expected.getAmount().equals(adapted.getAmount()));
		assertTrue(expected.getItemIds().get(0).equals(adapted.getItemIds().get(0)));
		assertTrue(expected.getItemIds().get(1).equals(adapted.getItemIds().get(1)));
		assertTrue(expected.getItemIds().get(2).equals(adapted.getItemIds().get(2)));
		assertTrue(expected.getItemIds().get(3).equals(adapted.getItemIds().get(3)));
		assertTrue(expected.getItemIds().get(4).equals(adapted.getItemIds().get(4)));
	}

}
