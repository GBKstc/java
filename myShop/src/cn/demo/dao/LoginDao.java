package cn.demo.dao;

import javax.sql.DataSource;

import cn.demo.domain.User;
import cn.demo.utils.DataSourceUtils;

public class LoginDao {
	private DataSource ds = DataSourceUtils.getDataSource();

	public void login(User user) {
		String sql = "";
		
	}

}
