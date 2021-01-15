package org.mperez.coupons.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mperez.coupons.factory.ItemsFactory;
import org.mperez.coupons.model.Item;

public class ItemUtils {
	
	public static Item getItemWithMaxPrice(List<Item> items) {
		return items.stream().reduce((item1,item2) -> item1.getAmount() >= item2.getAmount() ? item1 : item2).get();
	}
	
	public static List<Item> getItemsWithPriceLowerThanAmount(Map<String, Float> items, Float amount){
		List<Item> itemList = new ArrayList<Item>();
		items.forEach((i,a) -> itemList.add(ItemsFactory.createItem(i, a)));
		return itemList.stream().filter(item -> itemPriceIsLessThanAmount(item, amount)).collect(Collectors.toList());
	}
	
	public static Boolean itemPriceIsLessThanAmount(Item item, Float amount) {
		return item.getAmount() <= amount;
	}

}
