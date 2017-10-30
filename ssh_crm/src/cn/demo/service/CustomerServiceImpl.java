package cn.demo.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.demo.dao.CustomerDao;
import cn.demo.domain.Customer;
import cn.demo.utils.PageBean;

public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDao cd;
	
	Integer getCount() {
//		cd.getTotalCount(dc);
		return null;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer pageSize, Integer page) {
		Integer total = cd.getTotalCount(dc);
		PageBean pg = new PageBean(total, pageSize, page);
		Integer start = pg.getStart();
		System.out.println("start="+start);
		System.out.println("pageSize="+pg.getPageSize());
		List<Customer> list = cd.getPageList(dc, start, pg.getPageSize());
		pg.setList(list);
		
		return pg;
	}

	

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		System.out.println(customer);
		System.out.println(customer.getCust_level());
		cd.save(customer);
	}
	

}
