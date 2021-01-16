package org.mperez.coupons.adapter;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mperez.coupons.factory.CouponsFactory;
import org.mperez.coupons.model.Coupon;
import org.mperez.coupons.model.ItemsForCoupon;
import org.mperez.coupons.rest.model.CouponRequest;
import org.mperez.coupons.rest.model.CouponResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class CouponAdapterTest {
	
	@Autowired
	private CouponRequestAdapter couponRequestAdapter;
	
	@Autowired
	private CouponResponseAdapter couponResponseAdapter;
	
	private void compareRequests(CouponRequest expected, CouponRequest obtained) {
		assertTrue(expected.getAmount().equals(obtained.getAmount()));
		assertTrue(expected.getItemIds().get(0).equals(obtained.getItemIds().get(0)));
		assertTrue(expected.getItemIds().get(1).equals(obtained.getItemIds().get(1)));
		assertTrue(expected.getItemIds().get(2).equals(obtained.getItemIds().get(2)));
		assertTrue(expected.getItemIds().get(3).equals(obtained.getItemIds().get(3)));
		assertTrue(expected.getItemIds().get(4).equals(obtained.getItemIds().get(4)));
		assertEquals(expected, obtained);
	}
	
	private void compareCoupons(Coupon expected, Coupon obtained) {
		assertTrue(expected.getAmount().equals(obtained.getAmount()));
		assertTrue(expected.getItemIds().get(0).equals(obtained.getItemIds().get(0)));
		assertTrue(expected.getItemIds().get(1).equals(obtained.getItemIds().get(1)));
		assertTrue(expected.getItemIds().get(2).equals(obtained.getItemIds().get(2)));
		assertTrue(expected.getItemIds().get(3).equals(obtained.getItemIds().get(3)));
		assertTrue(expected.getItemIds().get(4).equals(obtained.getItemIds().get(4)));
	}
	
	private void compareResponses(CouponResponse expected, CouponResponse obtained) {
		assertTrue(expected.getTotal().equals(obtained.getTotal()));
		assertTrue(expected.getItemIds().get(0).equals(obtained.getItemIds().get(0)));
		assertTrue(expected.getItemIds().get(1).equals(obtained.getItemIds().get(1)));
		assertTrue(expected.getItemIds().get(2).equals(obtained.getItemIds().get(2)));
		assertTrue(expected.getItemIds().get(3).equals(obtained.getItemIds().get(3)));
		assertEquals(expected, obtained);
	}
	
	private void compareItemsForCoupons(ItemsForCoupon expected, ItemsForCoupon obtained) {
		assertTrue(expected.getTotal().equals(obtained.getTotal()));
		assertTrue(expected.getItemIds().get(0).equals(obtained.getItemIds().get(0)));
		assertTrue(expected.getItemIds().get(1).equals(obtained.getItemIds().get(1)));
		assertTrue(expected.getItemIds().get(2).equals(obtained.getItemIds().get(2)));
		assertTrue(expected.getItemIds().get(3).equals(obtained.getItemIds().get(3)));
	}
	
	@Test
	public void adaptModelShouldCreateExpectedRequestObject() {
		CouponRequest expected = new CouponRequest();
		expected.setAmount(new Float(100));
		expected.setItemIds(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"));
		
		Coupon example = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 100);
		
		CouponRequest adapted = couponRequestAdapter.adaptToView(example);
		compareRequests(expected, adapted);
		
	}
	
	@Test
	public void adaptRequestShouldCreateExpectedModelObject() {
		Coupon expected = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 100);
		
		CouponRequest example = new CouponRequest();
		example.setAmount(new Float(100));
		example.setItemIds(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"));
		
		Coupon adapted = couponRequestAdapter.adaptToModel(example);
		compareCoupons(expected, adapted);
	}
	
	@Test
	public void adaptListModelShouldCreateExpectedListRequestObject() {
		CouponRequest expected1 = new CouponRequest();
		expected1.setAmount(new Float(100));
		expected1.setItemIds(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"));
		
		CouponRequest expected2 = new CouponRequest();
		expected2.setAmount(new Float(200));
		expected2.setItemIds(Arrays.asList("MLA6","MLA7","MLA8","MLA9","MLA10"));
		
		Coupon example1 = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 100);
		Coupon example2 = CouponsFactory.createCoupon(Arrays.asList("MLA6","MLA7","MLA8","MLA9","MLA10"), 200);
		
		List<Coupon> coupons = new ArrayList<Coupon>();
		coupons.add(example1);
		coupons.add(example2);
		
		List<CouponRequest> couponRequests = couponRequestAdapter.adaptToView(coupons);
		compareRequests(expected1, couponRequests.get(0));
		compareRequests(expected2, couponRequests.get(1));
		
	}
	
	@Test
	public void adaptListRequestShouldCreateExpectedListModelObject() {
		Coupon expected1 = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 100);
		Coupon expected2 = CouponsFactory.createCoupon(Arrays.asList("MLA6","MLA7","MLA8","MLA9","MLA10"), 200);
		
		CouponRequest example1 = new CouponRequest();
		example1.setAmount(new Float(100));
		example1.setItemIds(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"));
		
		CouponRequest example2 = new CouponRequest();
		example2.setAmount(new Float(200));
		example2.setItemIds(Arrays.asList("MLA6","MLA7","MLA8","MLA9","MLA10"));
		
		List<CouponRequest> requests = new ArrayList<CouponRequest>();
		requests.add(example1);
		requests.add(example2);
		
		List<Coupon> coupons = couponRequestAdapter.adaptToModel(requests);
		compareCoupons(expected1, coupons.get(0));
		compareCoupons(expected2, coupons.get(1));
	}
	
	@Test
	public void adaptModelShouldCreateExpectedResponseObject() {
		Coupon coupon = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 500);
		ItemsForCoupon example = new ItemsForCoupon(Arrays.asList("MLA1","MLA2","MLA4","MLA5"), new Float(480), coupon);
		
		CouponResponse expected = new CouponResponse();
		expected.setTotal(new Float(480));
		expected.setItemIds(Arrays.asList("MLA1","MLA2","MLA4","MLA5"));
		
		CouponResponse adapted = couponResponseAdapter.adaptToView(example);
		compareResponses(expected, adapted);
		
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void adaptResponseThrowsUnsupportedOperationException() {
		Coupon coupon = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 500);
		
		CouponResponse example = new CouponResponse();
		example.setTotal(new Float(100));
		example.setItemIds(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"));
		
		ItemsForCoupon expected = new ItemsForCoupon(Arrays.asList("MLA1","MLA2","MLA4","MLA5"), new Float(480), coupon);
		
		ItemsForCoupon adapted = couponResponseAdapter.adaptToModel(example);
		compareItemsForCoupons(expected, adapted);
	}
	
	@Test
	public void adaptListModelShouldCreateExpectedListResponseObject() {
		Coupon coupon1 = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 500);
		Coupon coupon2 = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 1000);
		ItemsForCoupon example1 = new ItemsForCoupon(Arrays.asList("MLA1","MLA2","MLA4","MLA5"), new Float(480), coupon1);
		ItemsForCoupon example2 = new ItemsForCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), new Float(740), coupon2);
		
		CouponResponse expected1 = new CouponResponse();
		expected1.setTotal(new Float(480));
		expected1.setItemIds(Arrays.asList("MLA1","MLA2","MLA4","MLA5"));
		CouponResponse expected2 = new CouponResponse();
		expected2.setTotal(new Float(740));
		expected2.setItemIds(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"));
		
		List<ItemsForCoupon> items = new ArrayList<ItemsForCoupon>();
		items.add(example1);
		items.add(example2);
		
		List<CouponResponse> responses = couponResponseAdapter.adaptToView(items);
		compareResponses(expected1, responses.get(0));
		compareResponses(expected2, responses.get(1));
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void adaptListResponseShouldThrowUnsupportedOperationException() {
		Coupon coupon1 = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 500);
		Coupon coupon2 = CouponsFactory.createCoupon(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"), 1000);
		
		CouponResponse example1 = new CouponResponse();
		example1.setTotal(new Float(100));
		example1.setItemIds(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"));
		CouponResponse example2 = new CouponResponse();
		example2.setTotal(new Float(740));
		example2.setItemIds(Arrays.asList("MLA1","MLA2","MLA3","MLA4","MLA5"));
		
		List<CouponResponse> responses = new ArrayList<CouponResponse>();
		responses.add(example1);
		responses.add(example2);
		
		ItemsForCoupon expected1 = new ItemsForCoupon(Arrays.asList("MLA1","MLA2","MLA4","MLA5"), new Float(480), coupon1);
		ItemsForCoupon expected2 = new ItemsForCoupon(Arrays.asList("MLA1","MLA2", "MLA3","MLA4","MLA5"), new Float(740), coupon2);
		
		List<ItemsForCoupon> items = couponResponseAdapter.adaptToModel(responses);
		compareItemsForCoupons(expected1, items.get(0));
		compareItemsForCoupons(expected2, items.get(1));
	}

}
