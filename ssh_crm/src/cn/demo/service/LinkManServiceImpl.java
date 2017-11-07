package cn.demo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.demo.dao.LinkManDao;
import cn.demo.domain.Linkman;
import cn.demo.utils.PageBean;

public class LinkManServiceImpl implements LinkManService{
	private LinkManDao ld;

	public void setLd(LinkManDao ld) {
		this.ld = ld;
	}

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer pageSize, Integer page) {
		Integer total = ld.getTotalCount(dc);
		//默认显示20
		if(pageSize==null||pageSize==0) {
			pageSize=20;
		}
		PageBean pg = new PageBean(total, pageSize, page);
		Integer start = pg.getStart();
		System.out.println("start="+start);
		System.out.println("pageSize="+pg.getPageSize());
		List<Linkman> list = ld.getPageList(dc, start, pg.getPageSize());
		pg.setList(list);
		
		return pg;
	}

	@Override
	public void saveLinkMan(Linkman linkman) {
		ld.save(linkman);
		
	}

}
