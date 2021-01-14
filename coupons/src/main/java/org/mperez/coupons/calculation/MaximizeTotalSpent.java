package org.mperez.coupons.calculation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mperez.coupons.factory.ItemsFactory;
import org.mperez.coupons.model.Item;

public class MaximizeTotalSpent implements ItemsCalculation {

	public List<String> calculate(Map<String, Float> items, Float amount) {
		List<String> itemsCalculated = new ArrayList<String>();
		List<Item> itemsToCalculate = getItemsWithPriceLowerThanAmount(items, amount);
		
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
	
	public Boolean enableToAddItems(List<Item> oldItemsToCalculate, List<Item> newItemsToCalculate) {
		return newItemsToCalculate.size() < oldItemsToCalculate.size(); 
	}
	
	private Item getItemWithMaxPrice(List<Item> items) {
		return items.stream().reduce((item1,item2) -> item1.getAmount() >= item2.getAmount() ? item1 : item2).get();
	}
	
	
	private List<Item> getItemsWithPriceLowerThanAmount(Map<String, Float> items, Float amount){
		List<Item> itemList = new ArrayList<Item>();
		items.forEach((i,a) -> itemList.add(ItemsFactory.createItem(i, a)));
		return itemList.stream().filter(item -> itemPriceIsLessThanAmount(item, amount)).collect(Collectors.toList());
	}
	
	private Boolean itemPriceIsLessThanAmount(Item item, Float amount) {
		return item.getAmount() <= amount;
	}

}
