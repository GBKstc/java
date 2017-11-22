package cn.demo.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.demo.bean.Staff;
import cn.demo.service.StaffService;
import cn.demo.utils.SetResult;

public class StaffAction extends ActionSupport implements ModelDriven<Staff>{
	private static final long serialVersionUID = 1L;
	
	private Staff staff = new Staff();

	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}


	//获取staffList
	public String getStaffList() throws Exception {
		String json = SetResult.setResult("success", staffService.getStaffList());
		HttpServletResponse response = ServletActionContext.getResponse();
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}

	//添加staff
	public String addStaff() throws Exception {
		staffService.addStaff(staff);
		String json = SetResult.setDefaultResult();
		HttpServletResponse response = ServletActionContext.getResponse();
		ServletActionContext.getResponse().getWriter().write(json);
		return null;
	}

	@Override
	public Staff getModel() {
		// TODO Auto-generated method stub
		return staff;
	}

	
}
