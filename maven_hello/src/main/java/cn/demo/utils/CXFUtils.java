package cn.demo.utils;

import cn.demo.gbk.service.CustomerService;
import cn.demo.gbk.service.CustomerServiceImplService;

public class CXFUtils {
	
	private CustomerService service;
	
	public CustomerService getService() {
		return service;
	}

	public void setService(CustomerService service) {
		this.service = service;
	}

	public CXFUtils() {
		CustomerServiceImplService ss = new CustomerServiceImplService();
		service = ss.getCustomerServiceImplPort();
	}
	
	

}
