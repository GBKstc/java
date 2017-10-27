package cn.demo.dao;

import cn.demo.domain.User;

public interface UserDao extends BaseDao<User>{

	User getByUserCode(String code);
	
}
