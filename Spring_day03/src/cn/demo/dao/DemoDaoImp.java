package cn.demo.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
public class DemoDaoImp implements DemoDao{
//	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

//	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void fun() {
//		System.out.println(jdbcTemplate);
		String sql = "INSERT INTO t_user VALUES(null,?)";
		jdbcTemplate.update(sql,"gbk");
		int i = 1/0;
		jdbcTemplate.update(sql,"lq");
		System.out.println("success");
	}
	
}
