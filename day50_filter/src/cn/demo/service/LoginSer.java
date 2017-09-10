package cn.demo.service;

import cn.demo.Class.User;
import cn.demo.dao.LoginDao;

public class LoginSer {
	public static LoginDao ld = new LoginDao();

	public User userLogin(String username, String password) {
		// TODO Auto-generated method stub
		return ld.userLogin(username,password);
	}

}
