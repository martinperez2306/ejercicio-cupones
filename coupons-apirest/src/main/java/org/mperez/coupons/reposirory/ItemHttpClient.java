package org.mperez.coupons.reposirory;

import java.util.List;

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

	@Override
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item findById(String itemId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> findByIds(List<String> itemIds) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean deleteById(String itemId) {
		// TODO Auto-generated method stub
		return null;
	}

}
