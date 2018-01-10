package cn.demo.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.demo.bean.Decidedzone;
import cn.demo.service.DecidedzoneService;
import cn.demo.service.Impl.DecidedzoneServiceImpl;
import cn.demo.utils.SetResult;

public class DecidedzoneAction extends BaseAction<Decidedzone>{
	private static final long serialVersionUID = 1L;
	private String subareaList;
	public void setSubareaList(String subareaList) {
		this.subareaList = subareaList;
	}
	private DecidedzoneService decidedzoneService = new DecidedzoneServiceImpl();
	public void setDecidedzoneService(DecidedzoneService decidedzoneService) {
		this.decidedzoneService = decidedzoneService;
	}

	//获取DecidedzoneList
	public String getDecidedzoneList() throws Exception {
		String json = SetResult.setResult("success", decidedzoneService.getDecidedzoneList(page,pageSize));
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write(json);
		return null;
	}

	


	


	//添加staff
	public String addDecidedzone() throws Exception {
		
		String[] list = subareaList.split("\\,");
		List<String> subList = new ArrayList<String>();
		for (String string : list) {
			string = string.replaceAll("\\[|\\]|\"", "");
			subList.add(string);
		}
		decidedzoneService.addDecidedzone(model,subList);
		String json = SetResult.setDefaultResult();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write(json);
		return NONE;
	}
		



	
}
