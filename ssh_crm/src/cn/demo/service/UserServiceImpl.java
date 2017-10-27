package cn.demo.service;

import cn.demo.dao.UserDao;
import cn.demo.domain.User;

public class UserServiceImpl implements UserService{
	private UserDao ud;
	
	@Override
	public User getUserByCodePassword(User u) {
		User existU = ud.getByUserCode(u.getCode());
		if(existU==null) {
			throw new RuntimeException("用户名不存在");
		}
		if(!existU.getPassword().equals(u.getPassword())) {
			throw new RuntimeException("密码错误");
		}
		return null;
	}
	
	@Override
	public void saveUser(User u) {
		ud.save(u);
	}
	
	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	

}
