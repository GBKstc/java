package cn.demo.service;

import java.sql.Connection;
import java.sql.SQLException;

import cn.demo.util.DataSourceUtils;

public class Transfer {
	public static cn.demo.dao.Transfer dao = new cn.demo.dao.Transfer();
	public static Connection con = DataSourceUtils.getConnection();

	public void transfer(Double num, String out, String put) {
		try {
			con.setAutoCommit(false);
			dao.out(num, out);
			System.out.println("out");
			dao.put(num, put);
			System.out.println("put");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
}
