package cn.demo.service;

import java.sql.SQLException;

import cn.demo.dao.RegisterDao;
import cn.demo.domain.User;

public class RegisterSer {
	private static final RegisterDao rd = new RegisterDao();

	public boolean register(User user) {
		// TODO Auto-generated method stub
		try {
			return rd.refuster(user)==1?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
