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
		if(this.amount.equals(o.getAmount()))
			return 0;
		if(this.amount > o.getAmount())
			return 1;
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", amount=" + amount + "]";
	}

}
