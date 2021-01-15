package org.mperez.coupons.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.mperez.coupons.model.ItemsForCoupon;
import org.mperez.coupons.rest.model.CouponResponse;
import org.springframework.stereotype.Component;

@Component
public class CouponResponseAdapter implements Adapter<CouponResponse, ItemsForCoupon>{

	@Override
	public ItemsForCoupon adaptToModel(CouponResponse view) {
		throw new UnsupportedOperationException();
	}

	@Override
	public CouponResponse adaptToView(ItemsForCoupon model) {
		CouponResponse response = new CouponResponse();
		response.setItemIds(model.getItemIds());
		response.setTotal(model.getTotal());
		return response;
	}

	@Override
	public List<ItemsForCoupon> adaptToModel(List<CouponResponse> views) {
		return views.stream().map(v -> adaptToModel(v)).collect(Collectors.toList());
	}

	@Override
	public List<CouponResponse> adaptToView(List<ItemsForCoupon> models) {
		return models.stream().map(m -> adaptToView(m)).collect(Collectors.toList());
	}


}
