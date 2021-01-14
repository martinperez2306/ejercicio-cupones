package org.mperez.coupons.rest.api;

public class ApiException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4837889745871178108L;
	
	private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
