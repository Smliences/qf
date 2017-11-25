package com.sml.web.baseinterface;

import java.util.List;

public interface BaseInterface<E> {
	public void insert(E e); 
	
	public void delete(int id);
	
	public void update(E e);
	
	public List<E> query(int id);
}
