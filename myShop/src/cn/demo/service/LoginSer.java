package cn.demo.service;

import java.sql.SQLException;

import cn.demo.dao.LoginDao;
import cn.demo.domain.User;

public class LoginSer {
	private static final LoginDao ld = new LoginDao();

	public User login(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return ld.login(username,password);
	}

}
