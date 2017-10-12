package cn.demo.ser;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import cn.demo.dao.customerDao;
import cn.demo.dao.customerDaoImpl;
import cn.demo.domain.Customer;
import cn.demo.domain.Linkman;
import cn.demo.utils.HibernateUtil;

public class CustomerSerImpl implements CustomerSer {

	private customerDao customerDao = new customerDaoImpl();

	@Override
	public void save(Customer c) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.beginTransaction();
		customerDao.save(c);
		tx.commit();
		
		
		
	}

	@Override
	public List<Customer> listCustomerSer() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Customer> listCustomerSer = customerDao.listCustomerSer();
		tx.commit();
		return listCustomerSer;
	}

	@Override
	public void addLinkman(String cust_name, Linkman linkman) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.beginTransaction();
		customerDao.addLinkman(cust_name,linkman);
		tx.commit();
	}

	@Override
	public List<Customer> listCustomerSer(String cust_name) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Customer> listCustomerSer = customerDao.listCustomerSer(cust_name);
		tx.commit();
		return listCustomerSer;
	}

	@Override
	public List<Linkman> listLinkmanSer(DetachedCriteria dc) {
		// TODO Auto-generated method stub
		Session session  = HibernateUtil.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Linkman> listLinkmanDao = customerDao.listLinkmanDao(dc);
		tx.commit();
		return listLinkmanDao;
	}

}
