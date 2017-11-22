package cn.demo.service;

import java.util.List;

import cn.demo.bean.Staff;

public interface StaffService {

	List<Staff> getStaffList();

	void addStaff(Staff staff);



}
