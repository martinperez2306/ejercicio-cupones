package org.mperez.coupons.calculation;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.mperez.coupons.factory.ItemsFactory;
import org.mperez.coupons.model.Item;

public class MaximizeTotalSpentCalculationTest {
	
	private List<Item> allItems;
	private Float totalAmount;
	
	public void init() {
		this.allItems = new ArrayList<Item>();
		allItems.add(ItemsFactory.createItem("MLA1", 100));
		allItems.add(ItemsFactory.createItem("MLA2", 210));
		allItems.add(ItemsFactory.createItem("MLA3", 260));
		allItems.add(ItemsFactory.createItem("MLA4", 80));
		allItems.add(ItemsFactory.createItem("MLA5", 90));
		this.totalAmount = new Float(500);
	}
	
	@Test
	public void maximizeTotalSpentOnItems() {
		init();
		ItemsCalculation itemsCalculation = new MaximizeTotalSpent();
		Map<String, Float> itemsMap = new HashMap<String, Float>();
		for (Item item : allItems) {
			itemsMap.put(item.getId(), item.getAmount());
		}
		List<String> itemsCalculated = itemsCalculation.calculate(itemsMap, totalAmount);
		assertTrue(4 == itemsCalculated.size());
		assertTrue("MLA1".equals(itemsCalculated.get(0)));
		assertTrue("MLA2".equals(itemsCalculated.get(1)));
		assertTrue("MLA4".equals(itemsCalculated.get(2)));
		assertTrue("MLA5".equals(itemsCalculated.get(3)));
	}

}
