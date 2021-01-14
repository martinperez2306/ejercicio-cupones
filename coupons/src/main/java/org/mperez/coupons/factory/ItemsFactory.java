package org.mperez.coupons.factory;

import org.mperez.coupons.model.Item;

public class ItemsFactory {
	
	public static Item createItem(String id, Float amount) {
		return new Item(id, amount);
	}
	
	public static Item createItem(String id, Integer amount) {
		Float amountFloat = new Float(amount);
		return createItem(id, amountFloat);
	}

}
