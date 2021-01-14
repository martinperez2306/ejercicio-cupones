package org.mperez.coupons.reposirory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mperez.coupons.model.Item;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Repository;

@Repository
public class ItemMemory implements ItemRepository, InitializingBean {
	
	private Map<String, Item> itemsById;

	@Override
	public List<Item> findAll() {
		return new ArrayList<Item>(itemsById.values());
	}

	@Override
	public Item findById(String itemId) {
		return itemsById.get(itemId);
	}
	
	@Override
	public List<Item> findByIds(List<String> itemIds) {
		List<Item> items = new ArrayList<Item>();
		for (String id : itemIds) {
			if(itemIds.contains(id)) {
				items.add(itemsById.get(id));
			}
		}
		return items;
	}


	@Override
	public List<Item> findByMaxAmount(Float maxAmount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findByMinAmount(Float minAmount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Item item) {
		itemsById.put(item.getId(), item);
	}

	@Override
	public Boolean deleteById(String itemId) {
		return itemsById.remove(itemId) != null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.itemsById = new HashMap<String, Item>();
	}

}