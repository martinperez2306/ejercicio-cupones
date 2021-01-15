package org.mperez.coupons.validator;

import java.util.ArrayList;
import java.util.List;

import org.mperez.coupons.model.Coupon;

public class ItemsCouponValidator implements Validator<Coupon>{
	
	private Validator<Coupon> nextValidator;
	
	public ItemsCouponValidator() {
		this.nextValidator = new CouponAmountValidator();
	}

	@Override
	public List<ValidationError> validate(Coupon data) {
		List<ValidationError> errors = new ArrayList<ValidationError>();
		List<String> itemIds = data.getItemIds();
		if(itemIds == null || itemIds.isEmpty()) {
			ValidationError error = new ValidationError();
			error.setDetail("Item Ids are required!");
			errors.add(error);
		}else {
			nextValidator.validate(data);
		}
		return errors;
	}

}
