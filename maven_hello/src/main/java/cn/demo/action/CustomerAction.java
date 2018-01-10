package cn.demo.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import cn.demo.gbk.service.Customer;
import cn.demo.gbk.service.CustomerService;
import cn.demo.utils.CXFUtils;
import cn.demo.utils.GsonUtils;
import cn.demo.utils.SetResult;

public class CustomerAction extends BaseAction<Customer>{

	private static final long serialVersionUID = 1L;
	private CXFUtils cxfUtils;
	
	private String decideId;
	public void setDecideId(String decideId) {
		this.decideId = decideId;
	}
	private String list;
	public void setList(String list) {
		this.list = list;
	}

	public void setCxfUtils(CXFUtils cxfUtils) {
		this.cxfUtils = cxfUtils;
	}

	public void findNotBindingList() throws Exception{
		CustomerService service = cxfUtils.getService();
		List<Customer> list = service.findNotBindingList();
		String json = SetResult.setResult("success", list);
		ServletActionContext.getResponse().getWriter().write(json);
		
	}
	
	public void findHasBindingList() throws Exception{
		System.out.println(decideId);
		
		CustomerService service = cxfUtils.getService();
		List<Customer> list = service.findHasBindingList(decideId);
		String json = SetResult.setResult("success", list);
		ServletActionContext.getResponse().getWriter().write(json);
		
	}
	
	public void saveCustToDecide() throws Exception {
		
		Gson gson = new Gson();
		List<Customer> CustList = gson.fromJson(list, new TypeToken<List<Customer>>(){}.getType());

		CustomerService service = cxfUtils.getService();
		service.saveCustomer(CustList,decideId);
		String json = SetResult.setDefaultResult();
		ServletActionContext.getResponse().getWriter().write(json);
	}

}
