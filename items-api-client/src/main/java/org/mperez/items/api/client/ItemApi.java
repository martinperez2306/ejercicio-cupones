package org.mperez.items.api.client;

import java.net.URI;
import java.util.Arrays;

import org.mperez.items.api.client.model.Item;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class ItemApi {
	
	private RestTemplate restTemplate;
	
	private String baseUrl;
	
	public ItemApi(String baseUrl) {
		this.restTemplate = new RestTemplate();
		RestTemplate restTemplate = new RestTemplate();
	    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	    converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_HTML,  MediaType.APPLICATION_JSON));
	    restTemplate.getMessageConverters().add(converter);
		this.baseUrl = baseUrl;
	}
	
	public Item getById(String id) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_HTML);
		URI uri = new URI(baseUrl + "/" + id);
		ResponseEntity<Item> response = restTemplate.getForEntity(uri, Item.class);
		return response.getBody();
	}
	
}
