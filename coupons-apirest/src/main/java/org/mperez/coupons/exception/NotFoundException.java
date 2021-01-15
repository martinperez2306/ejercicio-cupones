package org.mperez.coupons.exception;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ApiException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8030097162044627842L;
	
	public NotFoundException() {
		super(HttpStatus.NOT_FOUND, new ArrayList<String>());
		addError("Resource not Found");
	}
	
	public NotFoundException(String error) {
		super(HttpStatus.NOT_FOUND, new ArrayList<String>());
		addError(error);
	}
}
