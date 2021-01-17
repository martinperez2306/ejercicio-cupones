package org.mperez.coupons.cache;

import java.util.HashMap;
import java.util.Map;

import org.mperez.coupons.model.Item;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class ItemCache implements Cache<Item>, InitializingBean {
	
	private Map<String, Item> itemsMap; 

	@Override
	public String save(Item cacheable) {
		if(cacheable != null) {
			itemsMap.put(cacheable.getId(), cacheable);
		}
		return cacheable.getId();
	}

	@Override
	public Boolean isPresent(String id) {
		return itemsMap.containsKey(id);
	}

	@Override
	public Item get(String id) {
		return itemsMap.get(id);
	}

	@Override
	public Boolean remove(String id) {
		Item removed = itemsMap.remove(id);
		return removed != null;
	}

	@Override
	public void clean() {
		itemsMap.clear();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.itemsMap = new HashMap<String, Item>();
	}

}
