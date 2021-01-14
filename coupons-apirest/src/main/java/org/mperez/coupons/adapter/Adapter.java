package org.mperez.coupons.adapter;

import java.util.List;

/**
 * Adaptador de objetos de la Vista y el Modelo
 * Adapta un objeto de la vista al modelo y viceversa.
 * V: Objeto de la vista
 * M: Objeto de Modelo
 * @author Martin Nicolas Perez
 *
 * @param <V>
 * @param <M>
 */
public interface Adapter<V,M> {
	
	public M adaptToModel(V view);
	public V adaptToView(M model);
	
	public List<M> adaptToModel(List<V> views);
	public List<V> adaptToView(List<M> models);

}
