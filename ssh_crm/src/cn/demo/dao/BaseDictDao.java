package cn.demo.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.demo.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict> {

	List<BaseDict> getBaseDictList(DetachedCriteria dc);

}
