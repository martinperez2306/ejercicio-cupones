package org.mperez.coupons.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class BadRequestException extends ApiException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5413719781342664719L;

	public BadRequestException() {
		super(HttpStatus.BAD_REQUEST, new ArrayList<String>());
		addError("Bad Request");
	}
	
	public BadRequestException(String error) {
		super(HttpStatus.BAD_REQUEST, new ArrayList<String>());
		addError(error);
	}
	
	public BadRequestException(List<String> errors) {
		super(HttpStatus.BAD_REQUEST, errors);
	}

}
