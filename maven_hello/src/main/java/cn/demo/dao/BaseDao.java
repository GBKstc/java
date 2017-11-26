package cn.demo.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	
	void save(T t);
	
	void saveOrUpdate(T t);
	
	void delete(T t);
	
	void delete(Serializable id);
	
	void updata(T t);
	
	T getById(Serializable id);
	
	Integer getTotalCount(DetachedCriteria dc);
	
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer size);
	List<T> getList(DetachedCriteria dc);

	T getByCode(String code);
	
	void excuteUpdate(String queryName,Object...objects);
	
	
}
