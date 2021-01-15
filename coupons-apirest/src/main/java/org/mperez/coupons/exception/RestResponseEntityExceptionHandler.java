package org.mperez.coupons.exception;

import org.mperez.coupons.rest.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Response> handleUnknownException(Exception ex, WebRequest request) {
		logger.error("Ocurrio un error desconocido", ex);
		Response response = new Response().status("FAILURE").addErrorsItem(ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<Response> handleApiException(ApiException ex, WebRequest request) {
		logger.error("Ocurrio un error en la invocacion de la API", ex);
		Response response = new Response().status("FAILURE").errors(ex.getErrors());
		return ResponseEntity.status(ex.getStatus()).body(response);
	}
}
