package org.mperez.coupons.rest.api;

public class NotFoundException extends ApiException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8030097162044627842L;
	
	private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
