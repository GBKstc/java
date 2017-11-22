package cn.demo.service.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.demo.bean.Staff;
import cn.demo.dao.StaffDao;
import cn.demo.service.StaffService;

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


}
