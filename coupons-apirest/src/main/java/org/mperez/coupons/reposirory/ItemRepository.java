package org.mperez.coupons.reposirory;

import java.util.List;

import org.mperez.coupons.model.Item;

public interface ItemRepository {
	
	public List<Item> findAll();
	
	public Item findById(String itemId);
	
	public List<Item> findByIds(List<String> itemIds);
	
	public void save(Item item);
	
	public Boolean deleteById(String itemId);
}
