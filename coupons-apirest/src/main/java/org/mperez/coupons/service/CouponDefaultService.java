package org.mperez.coupons.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mperez.coupons.cache.Cache;
import org.mperez.coupons.calculation.ItemsCalculation;
import org.mperez.coupons.exception.BadRequestException;
import org.mperez.coupons.exception.NotFoundException;
import org.mperez.coupons.exception.PreconditionFailedException;
import org.mperez.coupons.model.Coupon;
import org.mperez.coupons.model.Item;
import org.mperez.coupons.model.ItemsForCoupon;
import org.mperez.coupons.reposirory.ItemRepository;
import org.mperez.coupons.validator.ValidationError;
import org.mperez.coupons.validator.Validator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponDefaultService implements CouponService {
	
	private static final Logger logger = LoggerFactory.getLogger(CouponDefaultService.class);
	
	@Autowired
	private ItemsCalculation itemsCalculation;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private Validator<Coupon> couponValidator;
	
	@Autowired
	private Cache<Item> itemCache;

	@Override
	public ItemsForCoupon getItemsForCoupon(Coupon coupon) {
		logger.info("Entrando en Obtener Items Para Cupon");
		logger.debug("Obteniendo Items recomendados para Cupon [" + coupon.toString() +"]");
		List<ValidationError> errors = couponValidator.validate(coupon);
		if(!errors.isEmpty()) {
			logger.error("Se ha solicitado items recomendados para un Cupon no valido");
			throw new BadRequestException(errors.stream().map(e -> e.getDetail()).collect(Collectors.toList()));
		}
		Map<String, Float> itemMap = createItemMapFromCoupon(coupon);
		List<String> itemIds = itemsCalculation.calculate(itemMap, coupon.getAmount());
		return createItemsForCoupon(itemIds,coupon);
	}
	
	private List<Item> retrieveItems(Coupon coupon){
		List<Item> items = new ArrayList<Item>();
		List<String> itemIdsCached = coupon.getItemIds().stream().filter(id -> itemCache.isPresent(id)).collect(Collectors.toList());
		List<String> itemIdsNotCached = coupon.getItemIds().stream().filter(id -> !itemCache.isPresent(id)).collect(Collectors.toList());
		itemIdsCached.forEach(id -> items.add(itemCache.get(id)));
		List<Item> itemsFromApi = itemRepository.findByIds(itemIdsNotCached);
		itemsFromApi.forEach(item -> itemCache.save(item));
		items.addAll(itemsFromApi);
		return items;
	}
	
	private Boolean someItemWasNotFound(List<Item> itemsObtained, Coupon coupon) {
		return (coupon.getItemIds().size() > itemsObtained.size());
	}
	
	private Map<String, Float> createItemMapFromCoupon(Coupon coupon) {
		Map<String, Float> itemMap = new HashMap<String, Float>();
		List<Item> itemList = retrieveItems(coupon);
		if(someItemWasNotFound(itemList, coupon)) {
			logger.error("No se ha podido recuperar uno o mas Items del Cupon [" + coupon.toString() + "]");
			throw new PreconditionFailedException("No se ha podido recuperar uno o mas Items del Cupon");
		}
		for (Item item : itemList) {
			itemMap.put(item.getId(), item.getAmount());
		}
		return itemMap;
	}
	
	private ItemsForCoupon createItemsForCoupon(List<String> itemIds, Coupon coupon) {
		if(itemIds.isEmpty()) {
			logger.error("El monto en el Cupon [" + coupon.toString() + "] no es suficiente como para comprar minimamente un item");
			throw new NotFoundException("El monto no es suficiente como para comprar minimamente un item");
		}
		Float total = new Float(0);
		for (String id : itemIds) {
			Item item = itemRepository.findById(id);
			total = total + item.getAmount();
		}
		return new ItemsForCoupon(itemIds, total, coupon);
	}

}
