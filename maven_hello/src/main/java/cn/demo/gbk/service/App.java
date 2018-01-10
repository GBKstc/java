package cn.demo.gbk.service;

import java.util.List;

public class App {
	
	public static void main(String[] args) {
		System.out.println("aaa");
		CustomerServiceImplService ss = new CustomerServiceImplService();
		CustomerService service = ss.getCustomerServiceImplPort();
		List<Customer> list = service.findAll();
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}

}
