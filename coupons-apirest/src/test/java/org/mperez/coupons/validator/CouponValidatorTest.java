package org.mperez.coupons.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mperez.coupons.factory.CouponsFactory;
import org.mperez.coupons.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class CouponValidatorTest {

	@Autowired
	private Validator<Coupon> couponValidator;
	
	@Test
	public void validCouponShoulNotHaveErrors() {
		Coupon coupon = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 1000);
		List<ValidationError> errors = couponValidator.validate(coupon);
		assertTrue(errors.isEmpty());
	}
	
	@Test
	public void nullCouponShoulHaveErrors() {
		List<ValidationError> errors = couponValidator.validate(null);
		assertFalse(errors.isEmpty());
	}
	
	@Test
	public void couponWithoutItemsShoulHaveErrors() {
		Coupon coupon = CouponsFactory.createCoupon(Arrays.asList(), 1000);
		Coupon coupon2 = CouponsFactory.createCoupon(null, 1000);
		List<ValidationError> errors = couponValidator.validate(coupon);
		List<ValidationError> errors2 = couponValidator.validate(coupon2);
		assertFalse(errors.isEmpty());
		assertFalse(errors2.isEmpty());
	}
	
	@Test
	public void couponWithoutAmountShoulHaveErrors() {
		Coupon coupon = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 0);
		List<ValidationError> errors = couponValidator.validate(coupon);
		assertFalse(errors.isEmpty());
	}
	
	@Test
	public void couponWithoutAmountNullHaveErrors() {
		Coupon coupon = new Coupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), null);
		List<ValidationError> errors = couponValidator.validate(coupon);
		assertFalse(errors.isEmpty());
	}


}
