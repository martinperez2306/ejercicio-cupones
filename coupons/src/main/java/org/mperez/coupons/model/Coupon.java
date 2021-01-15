package org.mperez.coupons.model;

import java.util.List;

public class Coupon {
	
	private List<String> itemIds;
	private Float amount;
	
	public Coupon(List<String> itemIds, Float amount) {
		this.itemIds = itemIds;
		this.amount = amount;
	}

	public List<String> getItemIds() {
		return itemIds;
	}

	public Float getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Coupon [itemIds=" + itemIds + ", amount=" + amount + "]";
	}
	
}
