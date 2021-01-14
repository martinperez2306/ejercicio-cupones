package org.mperez.coupons.model;

public class Item {
	
	private String id;
	private Float amount;
	
	public Item(String id, Float amount) {
		this.id = id;
		this.amount = amount;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}

}
