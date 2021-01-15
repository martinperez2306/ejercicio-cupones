package org.mperez.coupons.calculation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mperez.coupons.factory.ItemsFactory;
import org.mperez.coupons.model.Item;
import org.mperez.coupons.utils.ItemUtils;

public class MaximizeTotalSpent implements ItemsCalculation {

	public List<String> calculate(Map<String, Float> items, Float amount) {
		List<String> itemsCalculated = new ArrayList<String>();
		List<Item> itemsToCalculate = ItemUtils.getItemsWithPriceLowerThanAmount(items, amount);
		
		Map<String, List<Item>> itemsByAcumulatedAmount = new HashMap<String, List<Item>>();
		itemsByAcumulatedAmount.put("0.0", new ArrayList<Item>());
		Collections.sort(itemsToCalculate);
		Collections.reverse(itemsToCalculate);
		for (Item item : itemsToCalculate) {
			List<Item> comparableItems = items.keySet().stream()
													  .filter(id -> !id.equals(item.getId()))
													  .map(id -> ItemsFactory.createItem(id, items.get(id)))
													  .collect(Collectors.toList());
			Collections.sort(comparableItems);
			Collections.reverse(comparableItems);
			while(comparableItems.size() > 0) {
				List<Item> acumulatedItems = new ArrayList<Item>();
				Float partialAmount = item.getAmount();
				acumulatedItems.add(item);
				for (Item itemComparable : comparableItems) {
					if(partialAmount + itemComparable.getAmount() <= amount) {
						partialAmount = partialAmount + itemComparable.getAmount();
						acumulatedItems.add(itemComparable);
					}
				}
				itemsByAcumulatedAmount.put(partialAmount.toString(), acumulatedItems);
				comparableItems.remove(0);
			}
		}
		
		Float maxAmount = itemsByAcumulatedAmount.keySet().stream().map(k -> new Float(k)).reduce((a1, a2) -> a1 > a2 ? a1 : a2).orElse(new Float(0));
		itemsCalculated = itemsByAcumulatedAmount.get(maxAmount.toString()).stream().map(item -> item.getId()).collect(Collectors.toList());
		Collections.sort(itemsCalculated);
		return itemsCalculated;
	}
	
}
