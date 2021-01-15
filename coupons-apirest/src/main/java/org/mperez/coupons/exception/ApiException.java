package org.mperez.coupons.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4837889745871178108L;
	
	private HttpStatus status;
	private List<String> errors;
	
	public ApiException() {
		status = HttpStatus.INTERNAL_SERVER_ERROR;
		errors = new ArrayList<String>();
	}
	
	public ApiException(HttpStatus status, List<String> errors) {
		this.status = status;
		this.errors = errors;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	
	public List<String> getErrors(){
		return errors;
	}
	
	protected void addError(String error) {
		this.errors.add(error);
	}
	
}
