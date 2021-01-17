package org.mperez.coupons.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class PreconditionFailedException extends ApiException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5921307892182531774L;
	
	public PreconditionFailedException() {
		super(HttpStatus.PRECONDITION_FAILED, new ArrayList<String>());
		addError("Bad Request");
	}
	
	public PreconditionFailedException(String error) {
		super(HttpStatus.PRECONDITION_FAILED, new ArrayList<String>());
		addError(error);
	}
	
	public PreconditionFailedException(List<String> errors) {
		super(HttpStatus.PRECONDITION_FAILED, errors);
	}

}
