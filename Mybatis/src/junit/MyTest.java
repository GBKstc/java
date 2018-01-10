package junit;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.demo.bean.User;
import cn.demo.dao.UserDao;

public class MyTest {

	public void function() throws IOException{
		//加载核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
	    //创建session工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//获取session
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("User.findById", 13);
		System.out.println(user);
	}
	
	
	public void function1() throws IOException {
		//加载核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
	    //创建session工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//获取session
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("User.findByName", "g");
		System.out.println(user);
	}
	
	
	public void function2() throws IOException {
		//加载核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
	    //创建session工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//获取session
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User();
		user.setName("高大侠");
		session.insert("User.add",user);
		session.commit();
		System.out.println(user.getId());
	}
	
	@Test
	public void function3() throws IOException {
		//加载核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
	    //创建session工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//获取session
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User();
		user.setName("aaa啦");
		user.setId(26);
		session.insert("User.updateById",user);
		session.commit();
		
	}
	
	@Test
	public void function4() throws IOException {
		//加载核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
	    //创建session工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//获取session
		SqlSession session = sqlSessionFactory.openSession();
		User user = new User();
		user.setName("啦啦");
		user.setId(26);
		session.insert("User.update",user);
		session.commit();
		
	}
	
	@Test
	public void function5() throws IOException {
		//加载核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
	    //创建session工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//获取session
		SqlSession session = sqlSessionFactory.openSession();
		UserDao mapper = session.getMapper(UserDao.class);
		System.out.println(mapper.findById(26));
	}
}
