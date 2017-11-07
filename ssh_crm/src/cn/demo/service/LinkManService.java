package cn.demo.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.demo.domain.Linkman;
import cn.demo.utils.PageBean;

public interface LinkManService {

	PageBean getPageBean(DetachedCriteria dc, Integer pageSize, Integer page);

	void saveLinkMan(Linkman linkman);

}
