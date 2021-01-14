package org.mperez.coupons.configuration;

import org.mperez.coupons.calculation.ItemsCalculation;
import org.mperez.coupons.calculation.MaximizeTotalSpent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CouponsConfiguration {
	
	@Bean
	public ItemsCalculation steamClient() {
		return new MaximizeTotalSpent();
	}
	
}
