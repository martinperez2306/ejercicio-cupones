package org.mperez.coupons.reposirory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mperez.coupons.factory.ItemsFactory;
import org.mperez.coupons.model.Item;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(value="repository.item", havingValue = "mem")
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
	
	private void initData() {
		itemsById.put("MLA1", ItemsFactory.createItem("MLA1", 100));
		itemsById.put("MLA1", ItemsFactory.createItem("MLA2", 210));
		itemsById.put("MLA3", ItemsFactory.createItem("MLA3", 260));
		itemsById.put("MLA4", ItemsFactory.createItem("MLA4", 80));
		itemsById.put("MLA5", ItemsFactory.createItem("MLA5", 90));
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.itemsById = new HashMap<String, Item>();
		initData();
	}

}