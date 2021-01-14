package org.mperez.coupons.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mperez.coupons.adapter.CouponAdapter;
import org.mperez.coupons.calculation.ItemsCalculation;
import org.mperez.coupons.model.Coupon;
import org.mperez.coupons.model.Item;
import org.mperez.coupons.reposirory.ItemRepository;
import org.mperez.coupons.rest.model.CouponInput;
import org.mperez.coupons.rest.model.CouponResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponDefaultService implements CouponService {
	
	@Autowired
	private ItemsCalculation itemsCalculation;
	
	@Autowired
	private CouponAdapter couponAdapter;
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public CouponResponse getItemsForCoupon(CouponInput couponInput) {
		Coupon coupon = couponAdapter.adaptToModel(couponInput);
		Map<String, Float> itemMap = new HashMap<String, Float>();
		List<Item> itemList = itemRepository.findByIds(coupon.getItemIds());
		for (Item item : itemList) {
			itemMap.put(item.getId(), item.getAmount());
		}
		List<String> itemsIds = itemsCalculation.calculate(itemMap, coupon.getAmount());
		CouponResponse response = new CouponResponse();
		response.setItemIds(itemsIds);
		Float total = new Float(0);
		for (String id : itemsIds) {
			Item item = itemRepository.findById(id);
			total = total + item.getAmount();
		}
		response.setTotal(total);
		return response;
	}

}
