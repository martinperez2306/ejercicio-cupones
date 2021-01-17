package org.mperez.coupons.scheduler;

import org.mperez.coupons.cache.Cache;
import org.mperez.coupons.model.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ItemScheduler {
	
	private static final Logger logger = LoggerFactory.getLogger(ItemScheduler.class);
	
	@Autowired
	private Cache<Item> itemCache;
	
	@Scheduled(fixedRateString ="${cache.item.clean.time}")
	public void clearItemCache() {
		logger.info("Limpiando cache de Items");
		itemCache.clean();
	}

}
