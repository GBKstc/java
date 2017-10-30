package cn.demo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.demo.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> getBaseDictList(DetachedCriteria dc);

}
