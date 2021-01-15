package org.mperez.coupons.model;

public class Item implements Comparable<Item>{
	
	private String id;
	private Float amount;
	
	public Item(String id, Float amount) {
		this.id = id;
		this.amount = amount;
	}
	
	public String getId() {
		return id;
	}
	
	public Float getAmount() {
		return amount;
	}
	
	@Override
	public int compareTo(Item o) {
		if(this.amount < o.getAmount())
			return -1;
		if(this.amount == o.getAmount())
			return 0;
		if(this.amount > o.getAmount())
			return 1;
		return 0;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", amount=" + amount + "]";
	}

}
