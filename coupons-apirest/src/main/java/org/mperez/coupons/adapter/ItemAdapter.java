package org.mperez.coupons.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.mperez.coupons.factory.ItemsFactory;
import org.mperez.coupons.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemAdapter implements Adapter<org.mperez.items.api.client.model.Item, org.mperez.coupons.model.Item>{

	@Override
	public Item adaptToModel(org.mperez.items.api.client.model.Item view) {
		return  ItemsFactory.createItem(view.getId(),view.getPrice());
	}

	@Override
	public org.mperez.items.api.client.model.Item adaptToView(Item model) {
		org.mperez.items.api.client.model.Item view = new org.mperez.items.api.client.model.Item();
		view.setId(model.getId());
		view.setPrice(model.getAmount());
		return view;
	}

	@Override
	public List<Item> adaptToModel(List<org.mperez.items.api.client.model.Item> views) {
		return views.stream().map(v -> adaptToModel(v)).collect(Collectors.toList());
	}

	@Override
	public List<org.mperez.items.api.client.model.Item> adaptToView(List<Item> models) {
		return models.stream().map(m -> adaptToView(m)).collect(Collectors.toList());
	}

}
