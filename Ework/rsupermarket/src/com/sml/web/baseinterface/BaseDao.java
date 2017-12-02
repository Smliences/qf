package com.sml.web.baseinterface;

import java.util.List;

public interface BaseDao<E> {
	public void insert(E e); 
	
	public void delete(int id);
	
	public void update(E e);
	
	public E query(int id);
}
