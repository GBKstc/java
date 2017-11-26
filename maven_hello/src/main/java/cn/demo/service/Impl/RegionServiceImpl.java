package cn.demo.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import cn.demo.bean.Region;
import cn.demo.dao.RegionDao;
import cn.demo.service.RegionService;
import cn.demo.utils.PageBean;

public class RegionServiceImpl implements RegionService{
	private RegionDao rd;
	private PageBean pageBean;

	public void setRd(RegionDao rd) {
		this.rd = rd;
	}

	@Override
	public List<Region> getRegionList() {
		DetachedCriteria dc = DetachedCriteria.forClass(Region.class);
		return rd.getPageList(dc, 0, 10);
	}

	@Override
	public void saveBatch(List<Region> regionList) {
		for (Region region : regionList) {
			rd.saveOrUpdate(region);
		}
	}

	@Override
	public Object getRegionList(Integer page, Integer pageSize) {
		DetachedCriteria dc = DetachedCriteria.forClass(Region.class);
		Integer total = rd.getTotalCount(dc);
		PageBean pageBean = new PageBean(total, page, pageSize);
		List<Region> list=  rd.getPageList(dc, (pageBean.getPage()-1)*pageBean.getPageSize(), 10);
		Map<String, Object> map = new HashMap<>();
		map.put("ObjData", list);
		map.put("pageData", pageBean);
		return map;
	}

}
