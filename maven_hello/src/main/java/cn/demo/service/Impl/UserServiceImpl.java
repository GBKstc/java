package cn.demo.service.Impl;

import cn.demo.bean.User;
import cn.demo.dao.UserDao;
import cn.demo.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao ud;

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	@Override
	public User getUser(User user) {
		return ud.getByCode(user.getCode());
	}
}
