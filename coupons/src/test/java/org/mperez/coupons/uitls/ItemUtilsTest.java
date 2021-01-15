package org.mperez.coupons.uitls;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.mperez.coupons.factory.ItemsFactory;
import org.mperez.coupons.model.Item;
import org.mperez.coupons.utils.ItemUtils;

public class ItemUtilsTest {
	
	private List<Item> allItems;
	
	public void init() {
		this.allItems = new ArrayList<Item>();
		allItems.add(ItemsFactory.createItem("MLA1", 100));
		allItems.add(ItemsFactory.createItem("MLA2", 210));
		allItems.add(ItemsFactory.createItem("MLA3", 260));
		allItems.add(ItemsFactory.createItem("MLA4", 80));
		allItems.add(ItemsFactory.createItem("MLA5", 90));
	}
	
	@Test
	public void getItemWithMaxPrice() {
		init();
		Item itemWithMaxPrice = ItemUtils.getItemWithMaxPrice(allItems);
		assertTrue(itemWithMaxPrice.getId().equals(allItems.get(2).getId()));
	}
	
	@Test
	public void getItemsWithPriceLowerThanAmount() {
		init();
		Float maxAmount = new Float(150);
		Map<String, Float> itemMap = new HashMap<String, Float>();
		allItems.stream().forEach(i -> itemMap.put(i.getId(), i.getAmount()));
		List<Item> items = ItemUtils.getItemsWithPriceLowerThanAmount(itemMap, maxAmount);
		assertTrue(3 == items.size());
	}

}
