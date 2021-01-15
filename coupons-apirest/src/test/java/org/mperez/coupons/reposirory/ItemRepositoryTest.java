package org.mperez.coupons.reposirory;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
	public void findAllItemsShouldNotBeNull() {
		List<Item> items = itemRepository.findAll();
		assertNotNull(items);
	}

	@Test
	public void saveNewItemShouldIncrementItems() {
		List<Item> items = itemRepository.findAll();
		Item newItem = ItemsFactory.createItem("MLA6", 7000);
		itemRepository.save(newItem);
		List<Item> itemsUpdated = itemRepository.findAll();
		
		assertTrue(itemsUpdated.size() == items.size() + 1);
	}
	
	@Test
	public void deleteItemShouldDecrementItems() {
		Item newItem = ItemsFactory.createItem("MLA7", 150);
		itemRepository.save(newItem);
		List<Item> items = itemRepository.findAll();
		
		itemRepository.deleteById("MLA7");
		List<Item> itemsUpdated = itemRepository.findAll();
		
		assertTrue(itemsUpdated.size() == items.size() - 1);
	}
	
	@Test
	public void getExistingItemByIdShouldReturnTheItem() {
		Item expected = ItemsFactory.createItem("MLA8", 7000);
		itemRepository.save(expected);
		
		Item obtained = itemRepository.findById("MLA8");
		assertTrue(expected.getId().equals(obtained.getId()));
		assertTrue(expected.getAmount().equals(obtained.getAmount()));
	}
	
	@Test
	public void getInexistingItemByIdShouldReturnNull() {
		Item obtained = itemRepository.findById("MLA9");
		assertNull(obtained);
	}
	
	@Test
	public void getExistingItemsByIdShouldReturnTheItem() {
		Item expected1 = ItemsFactory.createItem("MLA10", 7000);
		Item expected2 = ItemsFactory.createItem("MLA11", 8000);
		itemRepository.save(expected1);
		itemRepository.save(expected2);
		
		Item obtained1 = itemRepository.findById("MLA10");
		Item obtained2 = itemRepository.findById("MLA11");
		assertTrue(expected1.getId().equals(obtained1.getId()));
		assertTrue(expected1.getAmount().equals(obtained1.getAmount()));
		assertTrue(expected2.getId().equals(obtained2.getId()));
		assertTrue(expected2.getAmount().equals(obtained2.getAmount()));
	}

}
