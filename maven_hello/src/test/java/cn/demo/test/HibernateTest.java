package cn.demo.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.demo.bean.User;
import cn.demo.dao.UserDao;
import cn.demo.service.UserService;


//测试Hibernate
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
	@Resource(name="userDao")
	private UserDao us;
	@Test
	public void fun(){
		System.out.println(us);
		User user = new User();
		user.setCode("123");
		user.setPassword("123");
		User login = us.getByCode("123");
		System.out.println(login);
	}
}
