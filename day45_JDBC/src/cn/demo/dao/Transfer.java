package cn.demo.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import cn.demo.util.DataSourceUtils;
import cn.demo.util.MyThread;

public class Transfer {
	private static Connection con = DataSourceUtils.getConnection();
	
	public void out(Double num,String name) throws SQLException{
		QueryRunner qr = new QueryRunner();
		String sql = "UPDATE account SET num=num-? WHERE name=?";
		int update = qr.update(con,sql,num,name);
		
	}
	
	public void put(Double num,String name) throws SQLException{
		QueryRunner qr = new QueryRunner();
		String sql = "UPDATE account SET num=num+? WHERE name=?";
		int update = qr.update(con,sql,num,name);
	}

}
