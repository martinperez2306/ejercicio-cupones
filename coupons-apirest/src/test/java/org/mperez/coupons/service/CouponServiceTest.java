package org.mperez.coupons.service;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mperez.coupons.exception.BadRequestException;
import org.mperez.coupons.exception.NotFoundException;
import org.mperez.coupons.exception.PreconditionFailedException;
import org.mperez.coupons.factory.CouponsFactory;
import org.mperez.coupons.model.Coupon;
import org.mperez.coupons.model.ItemsForCoupon;
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
		Coupon coupon = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 500);
		ItemsForCoupon expected = new ItemsForCoupon(Arrays.asList("MLA1","MLA2","MLA4","MLA5"), new Float(480), coupon);
		
		ItemsForCoupon obtained = couponService.getItemsForCoupon(coupon);
		assertTrue(expected.getTotal().equals(obtained.getTotal()));
		assertTrue(expected.getItemIds().size() == obtained.getItemIds().size());
	}
	
	@Test(expected = BadRequestException.class)
	public void getItemsForInvalidCouponShouldThrowBadRequestException() {
		Coupon coupon = CouponsFactory.createCoupon(Arrays.asList(), 0);
		couponService.getItemsForCoupon(coupon);
	}
	
	@Test(expected = PreconditionFailedException.class)
	public void getItemsForCouponWithInexistingItemsShouldThrowPreConditionFailedException() {
		Coupon coupon = CouponsFactory.createCoupon(Arrays.asList("MLANOEXISTE1,MLANOEXISTE2,MLANOEXISTE3"), 5000);
		couponService.getItemsForCoupon(coupon);
	}
	
	@Test(expected = NotFoundException.class)
	public void getItemsForCouponWithInsufficientAmountShouldThrowNotFoundException() {
		Coupon coupon = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 30);
		couponService.getItemsForCoupon(coupon);
	}

}
