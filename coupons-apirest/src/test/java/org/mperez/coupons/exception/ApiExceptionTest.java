package org.mperez.coupons.exception;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpStatus;

public class ApiExceptionTest {
	
	@Test
	public void apiExceptionShouldHaveInternalServerError() {
		ApiException exception = new ApiException();
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getStatus());
		assertNotNull(exception.getErrors());
		assertTrue(exception.getErrors().isEmpty());
	}
	
	@Test
	public void badRequestExceptionShouldHaveInternalServerError() {
		ApiException exception = new BadRequestException();
		assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
		assertNotNull(exception.getErrors());
		assertFalse(exception.getErrors().isEmpty());
	}
	
	@Test
	public void notFoundExceptionShouldHaveNotFound() {
		ApiException exception = new NotFoundException();
		assertEquals(HttpStatus.NOT_FOUND, exception.getStatus());
		assertNotNull(exception.getErrors());
		assertFalse(exception.getErrors().isEmpty());
	}

	@Test
	public void preconditionFaliedExceptionShouldHaveNotFound() {
		ApiException exception = new PreconditionFailedException();
		assertEquals(HttpStatus.PRECONDITION_FAILED, exception.getStatus());
		assertNotNull(exception.getErrors());
		assertFalse(exception.getErrors().isEmpty());
	}
}
