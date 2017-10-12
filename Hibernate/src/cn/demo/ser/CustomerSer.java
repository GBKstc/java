package cn.demo.ser;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.demo.domain.Customer;
import cn.demo.domain.Linkman;

public interface CustomerSer {

	void save(Customer c);

	List<Customer> listCustomerSer(String cust_name);

	void addLinkman(String cust_name, Linkman linkman);

	List<Customer> listCustomerSer();

	List<Linkman> listLinkmanSer(DetachedCriteria dc);

}
