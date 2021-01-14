package org.mperez.coupons.rest.api;

import org.mperez.coupons.rest.model.Coupon;
import org.mperez.coupons.rest.model.CouponResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;

@Controller
public class CouponApiController implements CouponApi {

	private static final Logger log = LoggerFactory.getLogger(CouponApiController.class);

	public CouponApiController() {
		
	}

	public ResponseEntity<CouponResponse> getRecomendedItemsForCoupon(
			@ApiParam(value = "Cupon disponible. Contiene todos los items favoritos del Usuario y el monto maximo que puede gastar.") @RequestBody Coupon body) {
		return new ResponseEntity<CouponResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
