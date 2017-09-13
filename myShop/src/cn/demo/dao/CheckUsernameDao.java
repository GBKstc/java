package cn.demo.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.demo.domain.User;
import cn.demo.utils.DataSourceUtils;

public class CheckUsernameDao {
	private static DataSource ds = DataSourceUtils.getDataSource();

	public List<User> check(String username) throws SQLException {
		// TODO Auto-generated method stub
		String sql="SELECT * FROM `user` WHERE username=?";
		QueryRunner qr = new QueryRunner(ds);
		return qr.query(sql,new BeanListHandler<User>(User.class),username);
	}

}
