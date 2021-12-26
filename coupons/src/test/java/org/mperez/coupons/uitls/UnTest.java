package org.mperez.coupons.uitls;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mperez.coupons.model.Item;

public class UnTest {
	
	private void test(Item item) {
		item = new Item("2", new Float(200));
		System.out.println(item);
	}
	
	@Test
	public void test() {
		Item item = new Item("1", new Float(400));
		test(item);
		
		System.out.println(item);
	}
	
	@Test
	public void test2() {
		Item item1 = new Item("1", new Float(400));
		Item item2 = new Item("1", new Float(400));
		
		assertFalse(item1 == item2);
	}
	
	@Test
	public void test3() {
		Item item1 = new Item("1", new Float(400));
		Item item2 = new Item("1", new Float(400));
		
		assertTrue(item1.equals(item2));
	}
	
	
}
