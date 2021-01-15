package org.mperez.coupons.model;

import java.util.List;

public class ItemsForCoupon {
	
	private List<String> itemIds;
	private Float total;
	private Coupon coupon;
	
	public ItemsForCoupon(List<String> itemIds, Float total, Coupon coupon) {
		this.itemIds = itemIds;
		this.total = total;
		this.coupon = coupon;
	}

	public List<String> getItemIds() {
		return itemIds;
	}

	public Float getTotal() {
		return total;
	}

	public Coupon getCoupon() {
		return coupon;
	}

}
