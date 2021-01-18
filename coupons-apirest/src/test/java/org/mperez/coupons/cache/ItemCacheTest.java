package org.mperez.coupons.cache;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
public class ItemCacheTest {
	
	@Autowired
	private ItemCache itemCache;
	
	@Test
	public void itemNullShouldNotBeCacheable() {
		Item item = null;
		String cacheableId = itemCache.save(item);
		assertNull(cacheableId);
	}
	
	@Test
	public void saveItemShouldBeCacheable() {
		Item item = ItemsFactory.createItem("id1", 1000);
		String cacheableId = itemCache.save(item);
		assertTrue(itemCache.isPresent(cacheableId));
	}
	
	@Test
	public void removeItemShouldDeleteCacheable() {
		Item item = ItemsFactory.createItem("id1", 1000);
		String cacheableId = itemCache.save(item);
		assertTrue(itemCache.isPresent(cacheableId));
		
		Boolean removed = itemCache.remove(cacheableId);
		assertTrue(removed);
		assertFalse(itemCache.isPresent(cacheableId));
	}

}
