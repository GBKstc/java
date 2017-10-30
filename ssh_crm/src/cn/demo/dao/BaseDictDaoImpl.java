package cn.demo.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.demo.domain.BaseDict;

public class BaseDictDaoImpl extends BaseDaoImpl<BaseDict> implements BaseDictDao{

	@Override
	public List<BaseDict> getBaseDictList(DetachedCriteria dc) {
		List<BaseDict> list = (List<BaseDict>) getHibernateTemplate().findByCriteria(dc);
		return list;
	}

}
