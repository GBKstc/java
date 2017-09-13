package cn.demo.service;

import cn.demo.dao.LoginDao;
import cn.demo.domain.User;

public class LoginSer {
	private static final LoginDao ld = new LoginDao();

	public void login(User user) {
		// TODO Auto-generated method stub
		ld.login(user);
	}

}
