package org.mperez.coupons.reposirory;

import java.util.ArrayList;
import java.util.List;

import org.mperez.coupons.adapter.ItemAdapter;
import org.mperez.coupons.model.Item;
import org.mperez.items.api.client.ItemApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(value="repository.item", havingValue = "http")
public class ItemHttpClient implements ItemRepository{
	
	@Autowired
	private ItemApi itemApi;
	
	@Autowired
	private ItemAdapter itemAdapter;

	@Override
	public List<Item> findAll() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Item findById(String itemId) {
		try {
			return itemAdapter.adaptToModel(itemApi.getById(itemId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Item> findByIds(List<String> itemIds) {
		List<Item> items = new ArrayList<Item>();
		for (String id : itemIds) {
			Item item = findById(id);
			if(item != null)
				items.add(item);
		}
		return items;
	}

	@Override
	public void save(Item item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Boolean deleteById(String itemId) {
		throw new UnsupportedOperationException();
	}

}
