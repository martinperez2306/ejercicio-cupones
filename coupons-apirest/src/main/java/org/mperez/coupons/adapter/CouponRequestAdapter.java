package org.mperez.coupons.adapter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.mperez.coupons.factory.CouponsFactory;
import org.mperez.coupons.model.Coupon;
import org.mperez.coupons.rest.model.CouponRequest;
import org.springframework.stereotype.Component;

@Component
public class CouponRequestAdapter implements Adapter<CouponRequest, Coupon>{

	@Override
	public Coupon adaptToModel(CouponRequest view) {
		if(view == null)
			return CouponsFactory.createCoupon(Arrays.asList(), 0);
		return CouponsFactory.createCoupon(view.getItemIds(), view.getAmount());
	}

	@Override
	public CouponRequest adaptToView(Coupon model) {
		if(model == null)
			return new CouponRequest();
		return new CouponRequest().itemIds(model.getItemIds()).amount(model.getAmount());
	}

	@Override
	public List<Coupon> adaptToModel(List<CouponRequest> views) {
		return views.stream().map(v -> adaptToModel(v)).collect(Collectors.toList());
	}

	@Override
	public List<CouponRequest> adaptToView(List<Coupon> models) {
		return models.stream().map(m -> adaptToView(m)).collect(Collectors.toList());
	}

}
