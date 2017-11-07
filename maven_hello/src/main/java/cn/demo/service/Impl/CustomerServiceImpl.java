package cn.demo.service.Impl;

import cn.demo.bean.Customer;
import cn.demo.dao.CustomerDao;
import cn.demo.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDao cd;

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	@Override
	public Customer findCustomerById(Long custId) {
		
		return cd.getById(custId);
	}

}
