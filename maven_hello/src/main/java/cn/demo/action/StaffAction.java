package cn.demo.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.demo.bean.Staff;
import cn.demo.service.StaffService;
import cn.demo.utils.SetResult;

public class StaffAction extends BaseAction<Staff>{
	private static final long serialVersionUID = 1L;

	private StaffService staffService;
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}


	//获取staffList
	public String getStaffList() throws Exception {
		String json = SetResult.setResult("success", staffService.getStaffList(page,pageSize));
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write(json);
		return null;
	}

	//添加staff
	public String addStaff() throws Exception {
		String deltag = model.getDeltag();
		if(deltag ==null || deltag.isEmpty()) {
			model.setDeltag("0");
		}
		staffService.addStaff(model);
		String json = SetResult.setDefaultResult();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write(json);
		return null;
	}
	
	//删除staff
	public String delStaff() throws Exception {
		staffService.deleteStaff(model);
		String json = SetResult.setDefaultResult();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write(json);
		return null;
	}	
	
	//删除staff
	public String updateStaff() throws Exception {
		staffService.updateStaff(model);
		String json = SetResult.setDefaultResult();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write(json);
		return null;
	}	



	
}
