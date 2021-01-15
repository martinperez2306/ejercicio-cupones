package org.mperez.coupons.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mperez.coupons.calculation.ItemsCalculation;
import org.mperez.coupons.exception.BadRequestException;
import org.mperez.coupons.exception.NotFoundException;
import org.mperez.coupons.model.Coupon;
import org.mperez.coupons.model.Item;
import org.mperez.coupons.model.ItemsForCoupon;
import org.mperez.coupons.reposirory.ItemRepository;
import org.mperez.coupons.validator.ValidationError;
import org.mperez.coupons.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponDefaultService implements CouponService {
	
	@Autowired
	private ItemsCalculation itemsCalculation;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private Validator<Coupon> couponValidator;

	@Override
	public ItemsForCoupon getItemsForCoupon(Coupon coupon) {
		List<ValidationError> errors = couponValidator.validate(coupon);
		if(!errors.isEmpty()) {
			throw new BadRequestException(errors.stream().map(e -> e.getDetail()).collect(Collectors.toList()));
		}
		Map<String, Float> itemMap = createItemMapFromCoupon(coupon);
		List<String> itemIds = itemsCalculation.calculate(itemMap, coupon.getAmount());
		return createItemsForCoupon(itemIds,coupon);
	}
	
	private Map<String, Float> createItemMapFromCoupon(Coupon coupon){
		Map<String, Float> itemMap = new HashMap<String, Float>();
		List<Item> itemList = itemRepository.findByIds(coupon.getItemIds());
		for (Item item : itemList) {
			itemMap.put(item.getId(), item.getAmount());
		}
		return itemMap;
	}
	
	private ItemsForCoupon createItemsForCoupon(List<String> itemIds, Coupon coupon) {
		if(itemIds.isEmpty())
			throw new NotFoundException("El monto no sea suficiente como para comprar minimamente un item");
		Float total = new Float(0);
		for (String id : itemIds) {
			Item item = itemRepository.findById(id);
			total = total + item.getAmount();
		}
		return new ItemsForCoupon(itemIds, total, coupon);
	}

}
