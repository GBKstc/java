package cn.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import cn.demo.bean.User;
import cn.demo.dao.DemoDao;
import cn.demo.dao.DemoDaoImp;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo {
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	@Resource(name="transactionTemplate")
	private TransactionTemplate transactionTemplate;
	@Resource(name="demoDao")
	private DemoDao demoDao;



	public void setDemoDao(DemoDao demoDao) {
		this.demoDao = demoDao;
	}


	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Test
	public void fun() {
		
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql:///spring");
//		dataSource.setUsername("root");
//		dataSource.setPassword("");
		
//		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
//		String sql1 = "SELECT count(*) FROM t_user";
//		int i = jdbcTemplate.queryForObject(sql1, Integer.class);
//		System.out.println(i);
//		int i = 1/0;
//		String sql2 = "SELECT * FROM t_user";
//		List<User> query = jdbcTemplate.query(sql2, new RowMapper<User>() {
//
//			@Override
//			public User mapRow(ResultSet arg0, int arg1) throws SQLException {
//				User user = new User();
//				user.setId(arg0.getInt("id"));
//				user.setName(arg0.getString("id"));
//				return user;
//			}
//			
//		});
//		System.out.println(query);
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				String sql = "INSERT INTO t_user VALUES(null,?)";
				jdbcTemplate.update(sql,"gbk");
				int i = 1/0;
				jdbcTemplate.update(sql,"lq");
				System.out.println("success");
			}
		});
		
	}
	@Test
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void fun2() {
		String sql = "INSERT INTO t_user VALUES(null,?)";
		jdbcTemplate.update(sql,"gbk");
		int i = 1/0;
		jdbcTemplate.update(sql,"lq");
		System.out.println("success");
		
	}
	@Test
	public void fun1() {
//		System.out.println(demoDao);
		demoDao.fun();
	}

}
