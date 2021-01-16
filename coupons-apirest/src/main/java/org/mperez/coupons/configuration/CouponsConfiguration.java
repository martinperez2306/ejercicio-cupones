package org.mperez.coupons.configuration;

import org.mperez.coupons.calculation.ItemsCalculation;
import org.mperez.coupons.calculation.MaximizeTotalSpent;
import org.mperez.items.api.client.ItemApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CouponsConfiguration {
	
	@Value("${items.api.baseurl}")
	private String itemsApiBaseUrl;
	
	@Bean
	public ItemsCalculation itemsCalculation() {
		return new MaximizeTotalSpent();
	}
	
	@Bean
	public ItemApi itemApi() {
		return new ItemApi(itemsApiBaseUrl);
	}
	
}
