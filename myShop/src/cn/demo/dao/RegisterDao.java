package cn.demo.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import cn.demo.domain.User;
import cn.demo.utils.DataSourceUtils;

public class RegisterDao {
	private static DataSource ds = DataSourceUtils.getDataSource();

	public int refuster(User user) throws SQLException {
		String sql = "INSERT INTO `user`(uid,username,password,name,email,telephone,birthday,sex,state,code) VALUES (?,?,?,?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(ds);
		return qr.update(sql,user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode());
		
	}

}
