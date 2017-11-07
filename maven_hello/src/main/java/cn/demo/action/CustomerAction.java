package cn.demo.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.demo.bean.Customer;
import cn.demo.service.CustomerService;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	private static final long serialVersionUID = 1L;
	private Customer customer = new Customer();
	private CustomerService customerService;


	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	public String findCustById() throws IOException {
//		System.out.println(customer);
		customer = customerService.findCustomerById(customer.getCustId());
		System.out.println(customer);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write("Cust_id:"+customer.getCustName());
		return null; 
	}


	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
}
