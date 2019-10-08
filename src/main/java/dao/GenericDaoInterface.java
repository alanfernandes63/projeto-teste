package dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDaoInterface <T,ID extends Serializable>{
	
	public T save(T t);
	
	public List<T> findAll();
	
	public T delete(T t);
	
	public T update(T t);

}
