package cn.demo.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.demo.dao.BaseDao;
import cn.demo.dao.BaseDaoImpl;
import cn.demo.dao.CustomerDao;
import cn.demo.dao.CustomerDaoImpl;
import cn.demo.dao.UserDao;
import cn.demo.dao.UserDaoImpl;
import cn.demo.domain.Customer;
import cn.demo.domain.User;
import cn.demo.service.UserService;
import cn.demo.utils.PageBean;

//测试Hibernate
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
		@Resource(name="sessionFactory")
	private SessionFactory sf;
		@Resource(name="userDao")
	private UserDao ud;
		@Resource(name="userService")
	private UserService us;
		@Resource(name="customerDao")
	private CustomerDao cd ;
	public void fun() {
		
		Configuration conf = new Configuration().configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		u.setName("gbk");
		u.setPassword("123");
		
		session.save(u);
		
		
		
		tx.commit();
		session.close();
		
	}
	
	public void fun2() {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User u = new User();
		u.setName("李芊");
		u.setPassword("123");
		
		session.save(u);
		
		
		
		tx.commit();
		session.close();
		
	}
	
	public void fun3() {
		
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		
		User byUserName = ud.getByUserCode("gbk");
		
		System.out.println(byUserName);
		
		tx.commit();
		session.close();
	
		
	}

	public void fun4() {
		
		User u1 = new User();
		u1.setName("gbk1");
		u1.setPassword("123");
		u1.setCode("gbk");
		
		us.saveUser(u1);
		
	}
	
	@Test
	public void fun5() {
		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		dc.add(Restrictions.like("cust_name", "%"+"%"));
		System.out.println(cd.getTotalCount(dc));
		PageBean pb = new PageBean(10, null, null);
		pb.getStart();
	}


}
