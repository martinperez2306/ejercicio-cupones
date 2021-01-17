package org.mperez.coupons.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mperez.coupons.factory.ItemsFactory;
import org.mperez.coupons.model.Item;

public class ItemUtils {
	
	/**
	 * <h1> Obtener el item de Precio Maximo </h1>
	 * 
	 * Dado una lista de items regresa el item con mayor precio.
	 * <p>
	 * <strong>PRE:</strong> 
	 * Recibe el listado de items. <code>items</code> no puede ser null o bien un listado vacio.
	 * <p>
	 * <strong>POST:</strong> 
	 * Devuelve el item con mayor precio entre todo el listado de items.
	 * @param items
	 * @return
	 */
	public static Item getItemWithMaxPrice(List<Item> items) {
		return items.stream().reduce((item1,item2) -> item1.getAmount() >= item2.getAmount() ? item1 : item2).get();
	}
	
	/**
	 * <h1> Obtener Items con precio menor a un Monto determinado </h1>
	 * 
	 * Dado una lista de items y un monto regresa un sublistado de items que no superen dicho monto.
	 * <p>
	 * <strong>PRE:</strong> 
	 * Recibe el listado de items. 
	 * <code>items</code> no puede ser null o bien un listado vacio.
	 * <code>amount</code> no puede ser null.
	 * <p>
	 * <strong>POST:</strong> 
	 * Devuelve el item con mayor precio entre todo el listado de items.
	 * @param items
	 * @param amount
	 * @return
	 */
	public static List<Item> getItemsWithPriceLowerThanAmount(Map<String, Float> items, Float amount){
		List<Item> itemList = new ArrayList<Item>();
		items.forEach((i,a) -> itemList.add(ItemsFactory.createItem(i, a)));
		return itemList.stream().filter(item -> itemPriceIsLessOrEqualsThanAmount(item, amount)).collect(Collectors.toList());
	}
	
	/**
	 * <strong>PRE:</strong> 
	 * <code>item</code> no puede ser null.
	 * <code>amount</code> no puede ser null.
	 * <p>
	 * <strong>POST:</strong>
	 * Regresa <code>true</code> si el Precio del Item no supera el Monto, <code>false</code> en otro caso.
	 * @param item
	 * @param amount
	 * @return
	 */
	public static Boolean itemPriceIsLessOrEqualsThanAmount(Item item, Float amount) {
		return item.getAmount() <= amount;
	}

}
