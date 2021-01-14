package org.mperez.coupons.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.mperez.coupons.factory.CouponsFactory;
import org.mperez.coupons.model.Coupon;
import org.mperez.coupons.rest.model.CouponInput;
import org.springframework.stereotype.Component;

@Component
public class CouponAdapter implements Adapter<CouponInput, Coupon>{

	@Override
	public Coupon adaptToModel(CouponInput view) {
		return CouponsFactory.createCoupon(view.getItemIds(), view.getAmount());
	}

	@Override
	public CouponInput adaptToView(Coupon model) {
		return new CouponInput().itemIds(model.getItemIds()).amount(model.getAmount());
	}

	@Override
	public List<Coupon> adaptToModel(List<CouponInput> views) {
		return views.stream().map(v -> adaptToModel(v)).collect(Collectors.toList());
	}

	@Override
	public List<CouponInput> adaptToView(List<Coupon> models) {
		return models.stream().map(m -> adaptToView(m)).collect(Collectors.toList());
	}

}
