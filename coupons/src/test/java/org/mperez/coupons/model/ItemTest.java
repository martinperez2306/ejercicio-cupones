package org.mperez.coupons.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.mperez.coupons.factory.ItemsFactory;

public class ItemTest {
	
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
	public void orderList() {
		init();
		Collections.sort(allItems);
		for (Item item : allItems) {
			System.out.println(item);
		}
	}
	
	@Test
	public void reverseOrderList() {
		init();
		Collections.sort(allItems);
		Collections.reverse(allItems);
		for (Item item : allItems) {
			System.out.println(item);
		}
	}

}
