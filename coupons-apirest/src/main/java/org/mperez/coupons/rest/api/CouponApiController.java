package org.mperez.coupons.rest.api;

import org.mperez.coupons.adapter.CouponRequestAdapter;
import org.mperez.coupons.adapter.CouponResponseAdapter;
import org.mperez.coupons.model.ItemsForCoupon;
import org.mperez.coupons.rest.model.CouponRequest;
import org.mperez.coupons.rest.model.CouponResponse;
import org.mperez.coupons.service.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import io.swagger.annotations.ApiParam;

@Controller
public class CouponApiController implements CouponApi {
	
	@Autowired
	private CouponRequestAdapter couponRequestAdapter;
	
	@Autowired
	private CouponResponseAdapter couponResponseAdapter;
	
	@Autowired
	private CouponService couponService;

	private static final Logger logger = LoggerFactory.getLogger(CouponApiController.class);

	public CouponApiController() {
		
	}

	public ResponseEntity<CouponResponse> getRecomendedItemsForCoupon(
			@ApiParam(value = "Cupon disponible. Contiene todos los items favoritos del Usuario y el monto maximo que puede gastar.") @RequestBody CouponRequest body) {
		logger.info("Atendiendo pedido Obtener Items recomendados para Cupon");
		ItemsForCoupon itemsForCoupon = couponService.getItemsForCoupon(couponRequestAdapter.adaptToModel(body));
		return ResponseEntity.ok(couponResponseAdapter.adaptToView(itemsForCoupon));
	}

}
