package org.mperez.coupons.cache;

public interface Cache<T> {
	
	public String save(T cacheable);
	
	public Boolean isPresent(String id);
	
	public T get(String id);
	
	public Boolean remove(String id);
	
	public void clean();

}
