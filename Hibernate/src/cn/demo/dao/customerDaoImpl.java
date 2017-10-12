package cn.demo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;

import cn.demo.domain.Customer;
import cn.demo.domain.Linkman;
import cn.demo.utils.HibernateUtil;

public class customerDaoImpl implements customerDao {

	@Override
	public void save(Customer c) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getCurrentSession();
//		Transaction tx = session.beginTransaction();
//		System.out.println(c.getCust_name());
		session.save(c);
//		tx.commit();
//		session.close();
	}

	@Override
	public List<Customer> listCustomerSer() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getCurrentSession();
//		String sql = "From Customer";	
//		Query createQuery = session.createQuery(sql);
//		return createQuery.list();
		
//		Criteria criteria = session.createCriteria(Customer.class);
//		return criteria.list();
		
		String sql = "SELECT * FROM cst_customer";
		SQLQuery createSQLQuery = session.createSQLQuery(sql);
		createSQLQuery.addEntity(Customer.class);
		return createSQLQuery.list();
//		System.out.println(list);
	}

	@Override
	public void addLinkman(String cust_name, Linkman linkman) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getCurrentSession();
		String sql = "SELECT * FROM cst_customer WHERE cust_name=?;";
		SQLQuery createSQLQuery = session.createSQLQuery(sql);
		createSQLQuery.setString(0, cust_name);
		createSQLQuery.addEntity(Customer.class);
		Customer c = (Customer) createSQLQuery.uniqueResult();
		linkman.setCustomer(c);
		session.save(linkman);
	}

	@Override
	public List<Customer> listCustomerSer(String cust_name) {
		Session session = HibernateUtil.getCurrentSession();
		String sql = "SELECT * FROM cst_customer WHERE cust_name LIKE ?";
		SQLQuery createSQLQuery = session.createSQLQuery(sql);
		createSQLQuery.addEntity(Customer.class);
		createSQLQuery.setString(0, "%"+cust_name+"%");
		return createSQLQuery.list();
	}

	@Override
	public List<Linkman> listLinkmanDao(DetachedCriteria dc) {
		Session session = HibernateUtil.getCurrentSession();
		return dc.getExecutableCriteria(session).list();
		 
	}

}
