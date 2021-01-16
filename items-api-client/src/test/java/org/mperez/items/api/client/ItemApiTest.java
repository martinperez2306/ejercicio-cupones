package org.mperez.items.api.client;

import static org.junit.Assert.assertNotNull;

import java.net.URISyntaxException;

import org.junit.Test;
import org.mperez.items.api.client.model.Item;

public class ItemApiTest {

	private final static String baseUrl = "https://api.mercadolibre.com";
	
	@Test
	public void getItemsById() throws URISyntaxException {
		ItemApi api =  new ItemApi(baseUrl);
		String itemId1 = "MLA842945068";
		String itemId2 = "MLA842932586";
		
		Item item1 = api.getById(itemId1);
		Item item2 = api.getById(itemId2);
		
		assertNotNull(item1);
		assertNotNull(item1);
		System.out.println(item1);
		System.out.println(item2);
		
	}
}
