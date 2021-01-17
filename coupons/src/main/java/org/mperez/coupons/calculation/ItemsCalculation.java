package org.mperez.coupons.calculation;

import java.util.List;
import java.util.Map;

/**
 * Representa el Calculo de Items que un usuario puede comprar con un Cupon de
 * cierto monto maximizando el total gastado entre todos los items sin superar
 * el monto del cupon.
 * 
 * @author Martin Nicolas Perez
 *
 */
public interface ItemsCalculation {

	/**
	 * <h1>Calculo de Items</h1>
	 * 
	 * Dado un conjunto de Items y un monto total, regresa un listado de item Ids
	 * que pueden ser comprados sin superar el monto total. El listado de item IDs
	 * maximiza el total gastado considerando el precio de todos sus items, el cual
	 * puede ser menor o igual al monto total permitido. Si existe mas de un listado
	 * de items que asegure el gasto maximo, se devuelve el <strong>ultimo</strong>
	 * listado de items encontrado durante el calculo.
	 * 
	 * <p>
	 * 
	 * <strong>PRE:</strong> 
	 * Recibe los items que el usuario puede comprar y el
	 * monto total que puede gastar. <code>items</code> no puede ser null.
	 * <code>amount</code> no puede ser null.
	 * 
	 * <p>
	 * 
	 * <strong>POST:</strong> 
	 * Devuelve el listado con todos los itemsIDs que el
	 * usuario puede comprar sin superar el monto total. El resultado puede ser una
	 * lista de String vacia.
	 * 
	 * @param items Mapa de Items. La clave es el itemId y el valor es el precio del Item. 
	 * @param amount Monto total que se puede gastar entre todos los items.
	 * @return
	 */
	public List<String> calculate(Map<String, Float> items, Float amount);

}
