package cn.demo.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import cn.demo.bean.Region;
import cn.demo.bean.Staff;
import cn.demo.dao.StaffDao;
import cn.demo.service.StaffService;
import cn.demo.utils.PageBean;

public class StaffServiceImpl implements StaffService{
	private StaffDao sd;
	public void setSd(StaffDao sd) {
		this.sd = sd;
	}
	@Override
	public List<Staff> getStaffList() {
		
		DetachedCriteria dc = DetachedCriteria.forClass(Staff.class);
		
		return sd.getList(dc);
	}
	@Override
	public void addStaff(Staff staff) {
		sd.save(staff);
	}
	@Override
	public void deleteStaff(Staff staff) {
		sd.excuteUpdate("staff.del", staff.getId());
	}
	@Override
	public void updateStaff(Staff staff) {
		sd.updata(staff);
	}
	@Override
	public Object getStaffList(Integer page, Integer pageSize) {
		DetachedCriteria dc = DetachedCriteria.forClass(Staff.class);
		Integer total = sd.getTotalCount(dc);
		PageBean pageBean = new PageBean(total, page, pageSize);
		List<Staff> list=  sd.getPageList(dc, (pageBean.getPage()-1)*pageBean.getPageSize(), 10);
		Map<String, Object> map = new HashMap<>();
		map.put("ObjData", list);
		map.put("pageData", pageBean);
		return map;
	}


}
