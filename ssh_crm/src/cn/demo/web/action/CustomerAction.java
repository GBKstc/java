package cn.demo.web.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.demo.domain.Customer;
import cn.demo.service.CustomerService;
import cn.demo.utils.PageBean;


public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{

	private static final long serialVersionUID = 1L;
	private Customer customer = new Customer();
	
	private CustomerService customerService ;
	private Integer pageSize;
	private Integer page;
	
	public String list() throws Exception {
		System.out.println(pageSize);
		System.out.println(page);
		//封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		//判断并封装参数
		System.out.println(customer.getCust_name());
		if(StringUtils.isNotBlank(customer.getCust_name())){
			dc.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		}	
		PageBean pb = customerService.getPageBean(dc,pageSize,page);
		System.out.println(pb);
		ActionContext.getContext().put("pageBean", pb);
		return "list";
	}
	
	public String add() throws Exception {
		customerService.saveCustomer(customer);
		return "add";
	}
	
	public String delete() throws Exception {
		customerService.deleteCustomer(customer);
		System.out.println(customer);
		return "delete";
	}
	
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return customer;
	}
	
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

}
