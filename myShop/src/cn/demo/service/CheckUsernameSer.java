package cn.demo.service;

import java.sql.SQLException;
import java.util.List;

import cn.demo.dao.CheckUsernameDao;
import cn.demo.domain.User;

public class CheckUsernameSer {
	private static final CheckUsernameDao cud = new CheckUsernameDao();

	public List<User> check(String username) {
		// TODO Auto-generated method stub
		List<User> list = null;
		try {
			list = cud.check(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

}
