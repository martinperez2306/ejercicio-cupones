package org.mperez.coupons.validator;

import java.util.List;

public interface Validator<T> {
	
	public List<ValidationError> validate(T data);

}
