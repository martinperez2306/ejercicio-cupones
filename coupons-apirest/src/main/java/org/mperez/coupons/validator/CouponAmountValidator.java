package org.mperez.coupons.validator;

import java.util.ArrayList;
import java.util.List;

import org.mperez.coupons.model.Coupon;

public class CouponAmountValidator implements Validator<Coupon>{

	public CouponAmountValidator() {
		
	}

	@Override
	public List<ValidationError> validate(Coupon data) {
		List<ValidationError> errors = new ArrayList<ValidationError>();
		Float amount = data.getAmount();
		if(amount == null) {
			ValidationError error = new ValidationError();
			error.setDetail("Amount is required!");
			errors.add(error);
		}
		if(new Float(0).equals(amount)) {
			ValidationError error = new ValidationError();
			error.setDetail("Amount canot be 0!");
			errors.add(error);
		}
		return errors;
	}

}
