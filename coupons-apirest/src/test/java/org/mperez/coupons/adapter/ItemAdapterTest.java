package org.mperez.coupons.adapter;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mperez.coupons.factory.ItemsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class ItemAdapterTest {
	
	@Autowired
	private ItemAdapter itemAdapter;
	
	private void compareViews(org.mperez.items.api.client.model.Item expected, org.mperez.items.api.client.model.Item obtained) {
		assertTrue(expected.getId().equals(obtained.getId()));
		assertTrue(expected.getPrice().equals(obtained.getPrice()));
	}
	
	private void compareModels(org.mperez.coupons.model.Item expected, org.mperez.coupons.model.Item obtained) {
		assertTrue(expected.getId().equals(obtained.getId()));
		assertTrue(expected.getAmount().equals(obtained.getAmount()));
	}
	
	@Test
	public void adaptModelShouldCreateViewObject() {
		org.mperez.coupons.model.Item model = ItemsFactory.createItem("itemId1", 1000);
		org.mperez.items.api.client.model.Item expected = new org.mperez.items.api.client.model.Item();
		expected.setId("itemId1");
		expected.setPrice(new Float(1000));
		
		org.mperez.items.api.client.model.Item adapted = itemAdapter.adaptToView(model);
		compareViews(expected, adapted);
	}
	
	@Test
	public void adaptListModelShouldCreateListViewObject() {
		org.mperez.coupons.model.Item model1 = ItemsFactory.createItem("itemId1", 1000);
		org.mperez.coupons.model.Item model2 = ItemsFactory.createItem("itemId2", 2000);
		
		org.mperez.items.api.client.model.Item expected1 = new org.mperez.items.api.client.model.Item();
		expected1.setId("itemId1");
		expected1.setPrice(new Float(1000));
		org.mperez.items.api.client.model.Item expected2 = new org.mperez.items.api.client.model.Item();
		expected2.setId("itemId2");
		expected2.setPrice(new Float(2000));
		
		List<org.mperez.coupons.model.Item> models = new ArrayList<>();
		models.add(model1);
		models.add(model2);
		
		List<org.mperez.items.api.client.model.Item> adaptedList = itemAdapter.adaptToView(models);
		assertNotNull(adaptedList);
		assertFalse(adaptedList.isEmpty());
		compareViews(expected1, adaptedList.get(0));
		compareViews(expected2, adaptedList.get(1));
	}
	
	@Test
	public void adaptViewShouldCreateModelObject() {
		org.mperez.items.api.client.model.Item view = new org.mperez.items.api.client.model.Item();
		view.setId("itemId1");
		view.setPrice(new Float(1000));
		
		org.mperez.coupons.model.Item expected = ItemsFactory.createItem("itemId1", 1000);
		org.mperez.coupons.model.Item adapted = itemAdapter.adaptToModel(view);
		
		compareModels(expected, adapted);
	}
	
	@Test
	public void adaptListViewShouldCreateListModelObject() {
		org.mperez.items.api.client.model.Item view1 = new org.mperez.items.api.client.model.Item();
		view1.setId("itemId1");
		view1.setPrice(new Float(1000));
		org.mperez.items.api.client.model.Item view2 = new org.mperez.items.api.client.model.Item();
		view2.setId("itemId2");
		view2.setPrice(new Float(2000));
		
		org.mperez.coupons.model.Item expected1 = ItemsFactory.createItem("itemId1", 1000);
		org.mperez.coupons.model.Item expected2 = ItemsFactory.createItem("itemId2", 2000);
		List<org.mperez.items.api.client.model.Item> views = new ArrayList<>();
		views.add(view1);
		views.add(view2);
		
		List<org.mperez.coupons.model.Item> adaptedList = itemAdapter.adaptToModel(views);
		
		assertNotNull(adaptedList);
		assertFalse(adaptedList.isEmpty());
		compareModels(expected1, adaptedList.get(0));
		compareModels(expected2, adaptedList.get(1));
	}

}
