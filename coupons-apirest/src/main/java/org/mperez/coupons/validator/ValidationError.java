package org.mperez.coupons.validator;

/**
 * Esta clase tiene la responsabilidad de modelar
 * los errores de respuesta.
 * 
 * Ofrece un detalle del error ocurrido.
 * @author Martin Nicolas Perez
 *
 */
public class ValidationError {

	private String detail;

	public ValidationError() {
		detail = "";
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
