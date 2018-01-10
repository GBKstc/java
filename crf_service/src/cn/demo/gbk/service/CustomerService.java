package cn.demo.gbk.service;

import java.util.List;

import javax.jws.WebService;

import cn.demo.gbk.domain.Customer;
@WebService
public interface CustomerService {
	
	public List<Customer> findAll();
	
	public List<Customer> findNotBindingList();
	
	public List<Customer> findHasBindingList(String decidedzone_id);
	
	public void saveCustomer(List<Customer> list,String decidedzone_id);
  
}
