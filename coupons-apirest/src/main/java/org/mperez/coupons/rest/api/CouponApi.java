/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.19).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package org.mperez.coupons.rest.api;

import org.mperez.coupons.rest.model.CouponRequest;
import org.mperez.coupons.rest.model.CouponResponse;
import org.mperez.coupons.rest.model.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@Api(value = "coupon", description = "the coupon API")
public interface CouponApi {

    @ApiOperation(value = "Consulta de Items que puede comprar el Usuario", nickname = "getRecomendedItemsForCoupon", notes = "Recibe un conjunto de items y el monto maximo del cupon y devuelve los items que el usuario puedee comprar sin superar el limite del cupon.", response = CouponResponse.class, tags={ "Cupones", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Equipo registrado exitosamente", response = CouponResponse.class),
        @ApiResponse(code = 400, message = "Solicitud invalida. Datos invalidos o incompletos.", response = Response.class),
        @ApiResponse(code = 404, message = "El monto no sea suficiente como para comprar mínimamente un item.", response = Response.class),
        @ApiResponse(code = 412, message = "No se ha podido recuperar informacion de uno o mas items favoritos del Usuario.", response = Response.class),
        @ApiResponse(code = 500, message = "Error interno del servidor", response = Response.class) })
    @RequestMapping(value = "/coupon/",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<CouponResponse> getRecomendedItemsForCoupon(@ApiParam(value = "Cupon disponible. Contiene todos los items favoritos del Usuario y el monto maximo que puede gastar."  )  @RequestBody CouponRequest body
);

}
