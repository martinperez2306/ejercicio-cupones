package org.mperez.items.api.client;

import org.mperez.items.api.client.model.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ItemApi {
	
	private RestTemplate restTemplate;
	
	private String baseUrl;

	public ItemApi() {
		this.restTemplate = new RestTemplate();
		this.baseUrl = "/";
	}
	
	public ItemApi(String baseUrl) {
		this.restTemplate = new RestTemplate();
		this.baseUrl = baseUrl;
	}
	
	public Item getById(String id) {
		ResponseEntity<Item> response = restTemplate.getForEntity(baseUrl + "/"+id, Item.class);
		return response.getBody();
	}

}
