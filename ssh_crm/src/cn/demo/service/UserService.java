package cn.demo.service;

import cn.demo.domain.User;

public interface UserService {
	
	User getUserByCodePassword(User u);
	void saveUser(User u);
}
