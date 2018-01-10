package cn.demo.dao;

import cn.demo.bean.User;

public interface UserDao {
	
	public User findById(Integer id);
}
