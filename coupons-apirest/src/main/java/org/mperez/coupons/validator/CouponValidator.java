package org.mperez.coupons.validator;

import java.util.ArrayList;
import java.util.List;

import org.mperez.coupons.model.Coupon;
import org.springframework.stereotype.Component;

@Component
public class CouponValidator implements Validator<Coupon>{
	
	private Validator<Coupon> nextValidator;
	
	public CouponValidator() {
		this.nextValidator = new ItemsCouponValidator();
	}

	@Override
	public List<ValidationError> validate(Coupon data) {
		List<ValidationError> errors = new ArrayList<ValidationError>();
		if(data == null) {
			ValidationError error = new ValidationError();
			error.setDetail("Coupon is required!");
			errors.add(error);
		}else {
			nextValidator.validate(data);
		}
		return errors;
	}

}
