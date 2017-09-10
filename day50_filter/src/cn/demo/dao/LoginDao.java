package cn.demo.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.demo.Class.User;
import cn.demo.utils.DataSourceUtils;

public class LoginDao {
	private static DataSource ds = DataSourceUtils.getDataSource();

	public User userLogin(String username, String password) {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(ds);
		String sql = "SELECT * FROM `user` WHERE username=?&&`password`=?";
		User user = new User();
		try {
			user = qr.query(sql, new BeanHandler<User>(User.class),username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
