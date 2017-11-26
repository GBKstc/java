package cn.demo.dao.Impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.demo.bean.User;
import cn.demo.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	private Class clazz;
	
	public BaseDaoImpl() {
		super();
		//获得当前类型的父类(带有泛型)
		ParameterizedType ptClass = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class) ptClass.getActualTypeArguments()[0];
	}

	@Override
	public void save(T t) {
		getHibernateTemplate().save(t);
	}

	@Override
	public void delete(T t) {
		getHibernateTemplate().delete(t);
	}

	@Override
	public void delete(Serializable id) {
		T t = this.getById(id);
		getHibernateTemplate().delete(t);
	}

	@Override
	public void updata(T t) {
		getHibernateTemplate().update(t);
	}

	@Override
	public T getById(Serializable id) {
		
		return (T) getHibernateTemplate().get(clazz, id);
	}
	
	@Override
	public T getByCode(final String code) {
		
		return (T) getHibernateTemplate().execute(new HibernateCallback<T>() {

		

			@Override
			public T doInHibernate(Session session) throws HibernateException {
				String sql = "SELECT * FROM `user` WHERE `code`=?";
				SQLQuery sqlQuery = session.createSQLQuery(sql);
				sqlQuery.addEntity(clazz);
				sqlQuery.setParameter(0, code);
				return (T) sqlQuery.uniqueResult();
			}
		});
	}

	@Override
	public Integer getTotalCount(DetachedCriteria dc) {
		dc.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) getHibernateTemplate().findByCriteria(dc);
		dc.setProjection(null);
		
		if(list!=null&&list.size()>0) {
			Long count = list.get(0);
			return count.intValue();
		}
		return null;
	}

	@Override
	public List<T> getPageList(DetachedCriteria dc, Integer start, Integer size) {
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc,start,size);
		return list;
	}

	@Override
	public List<T> getList(DetachedCriteria dc) {
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}

	@Override
	public void excuteUpdate(String queryName, Object... objects) {
		Session session = this.getSessionFactory().getCurrentSession();
		Query query = session.getNamedQuery(queryName);
		for (int i = 0; i < objects.length; i++) {
			query.setParameter(i, objects[i]);
		}
		query.executeUpdate();
	}

	@Override
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}

}
