package cn.demo.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import cn.demo.bean.Decidedzone;
import cn.demo.bean.Subarea;
import cn.demo.dao.DecidedzoneDao;
import cn.demo.dao.SubareaDao;
import cn.demo.service.DecidedzoneService;
import cn.demo.utils.PageBean;

public class DecidedzoneServiceImpl implements DecidedzoneService {
	private DecidedzoneDao dd;
	private SubareaDao sud;
	public void setDd(DecidedzoneDao dd) {
		this.dd = dd;
	}
	

	public void setSud(SubareaDao sud) {
		this.sud = sud;
	}


	@Override
	public void addDecidedzone(Decidedzone model, List<String> subList) {
		System.out.println(model);
		System.out.println(subList);
		dd.save(model);
		for (String string : subList) {
			Subarea subarea = sud.getById(string);
			subarea.setDecidedzone(model);
		}
	}


	@Override
	public Object getDecidedzoneList(Integer page, Integer pageSize) {
		DetachedCriteria dc = DetachedCriteria.forClass(Decidedzone.class);
		Integer total = dd.getTotalCount(dc);
		PageBean pageBean = new PageBean(total, page, pageSize);
		List<Decidedzone> list=  dd.getPageList(dc, (pageBean.getPage()-1)*pageBean.getPageSize(), 10);
		Map<String, Object> map = new HashMap<>();
		map.put("ObjData", list);
		map.put("pageData", pageBean);
		return map;
	}

}
