package cn.demo.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.demo.bean.Region;
import cn.demo.bean.Subarea;
import cn.demo.dao.SubareaDao;
import cn.demo.service.SubareaService;
import cn.demo.utils.PageBean;

public class SubareaServiceImpl implements SubareaService{
	private SubareaDao sud;
	public void setSud(SubareaDao sud) {
		this.sud = sud;
	}
	@Override
	public void addSubarea(Subarea model) {
		sud.save(model);
	}
	
	@Override
	public List<Subarea> getSubareaList() {
		DetachedCriteria dc = DetachedCriteria.forClass(Subarea.class);
		return sud.getList(dc);
	}
	
	@Override
	public Map<String, Object> getSubareaList(Integer page, Integer pageSize) {
		DetachedCriteria dc = DetachedCriteria.forClass(Subarea.class);
		Integer total = sud.getTotalCount(dc);
		PageBean pageBean = new PageBean(total, page, pageSize);
		List<Subarea> list=  sud.getPageList(dc, (pageBean.getPage()-1)*pageBean.getPageSize(), 10);
		Map<String, Object> map = new HashMap<>();
		map.put("ObjData", list);
		map.put("pageData", pageBean);
		return map;
	}
	@Override
	public Map<String, Object> getSubareaList(Integer page, Integer pageSize, Subarea model) {
		DetachedCriteria dc = DetachedCriteria.forClass(Subarea.class);
		Region region = model.getRegion();
		
//		dc.createAlias("decidedzone", "d");
		if(region!=null) {
			dc.createAlias("region", "r");
			String regionId = region.getId();
//			String postcode = region.getPostcode();
//			String city = region.getCity();
//			String district = region.getDistrict();
			if(StringUtils.isNotBlank(regionId)) {
				dc.add(Restrictions.like("r.id", regionId));
			}
		}
		
		Integer total = sud.getTotalCount(dc);
		PageBean pageBean = new PageBean(total, page, pageSize);
		List<Subarea> list=  sud.getPageList(dc, (pageBean.getPage()-1)*pageBean.getPageSize(), pageBean.getPageSize());
		Map<String, Object> map = new HashMap<>();
		map.put("ObjData", list);
		map.put("pageData", pageBean);
		return map;
	}

}
