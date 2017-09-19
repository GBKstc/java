package cn.demo.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.demo.domain.User;
import cn.demo.utils.DataSourceUtils;

public class LoginDao {
	private DataSource ds = DataSourceUtils.getDataSource();


	public User login(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(ds);
		String sql = "SELECT * FROM `user` WHERE username=?&&`password`=?";
		return qr.query(sql, new BeanHandler<User>(User.class),username,password);
	}

}
