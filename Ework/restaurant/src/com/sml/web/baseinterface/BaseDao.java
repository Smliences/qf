package com.sml.web.baseinterface;

import java.util.List;

public interface BaseDao<E> {
	public List<E> queryList();
	public void insert(E e);
	public E queryById(int id);
	public void update(E e);
	public void deleteById(int id);
	
}
