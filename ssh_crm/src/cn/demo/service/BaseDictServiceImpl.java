package cn.demo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.demo.dao.BaseDictDao;
import cn.demo.domain.BaseDict;

public class BaseDictServiceImpl implements BaseDictService {
	
	private BaseDictDao bd;

	public void setBd(BaseDictDao bd) {
		this.bd = bd;
	}

	@Override
	public List<BaseDict> getBaseDictList(DetachedCriteria dc) {
		
		return bd.getBaseDictList(dc);
	}

	

}
