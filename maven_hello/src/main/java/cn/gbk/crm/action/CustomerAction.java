package cn.gbk.crm.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {
	
	private Long cust_id;

	public Long getCust_id() {
		return cust_id;
	}

	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}

	public String findCustById() throws IOException {
//		System.out.println("Cust_id:"+cust_id);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write("Cust_id:"+cust_id);
		return null; 
	}
}
