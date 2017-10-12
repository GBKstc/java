package cn.demo.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.demo.domain.Customer;
import cn.demo.domain.Linkman;

public interface customerDao {

	void save(Customer c);

	List<Customer> listCustomerSer(String cust_name);

	void addLinkman(String cust_name, Linkman linkman);

	List<Customer> listCustomerSer();

	List<Linkman> listLinkmanDao(DetachedCriteria dc);

}
