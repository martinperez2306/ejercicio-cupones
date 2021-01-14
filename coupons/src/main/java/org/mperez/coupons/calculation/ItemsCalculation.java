package org.mperez.coupons.calculation;

import java.util.List;
import java.util.Map;

public interface ItemsCalculation {
	
	public List<String> calculate(Map<String, Float> items, Float amount);

}
