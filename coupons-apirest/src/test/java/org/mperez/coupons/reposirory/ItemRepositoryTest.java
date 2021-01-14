package org.mperez.coupons.reposirory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mperez.coupons.factory.ItemsFactory;
import org.mperez.coupons.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class ItemRepositoryTest {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	public void findAllItems() {
		List<Item> items = itemRepository.findAll();
		assertNotNull(items);
	}

	@Test
	public void saveNewItem() {
		List<Item> items = itemRepository.findAll();
		Item newItem = ItemsFactory.createItem("MLA6", 7000);
		itemRepository.save(newItem);
		List<Item> itemsUpdated = itemRepository.findAll();
		
		assertTrue(itemsUpdated.size() == items.size() + 1);
	}
	
	@Test
	public void deleteItem() {
		Item newItem = ItemsFactory.createItem("MLA7", 150);
		itemRepository.save(newItem);
		List<Item> items = itemRepository.findAll();
		
		itemRepository.deleteById("MLA7");
		List<Item> itemsUpdated = itemRepository.findAll();
		
		assertTrue(itemsUpdated.size() == items.size() - 1);
	}

}
