package cn.demo03;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

import com.mchange.v2.c3p0.*;

public class HomeWork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComboPooledDataSource cpds = new ComboPooledDataSource();
//		try {
//			System.out.println(cpds.getConnection());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM gjp_zhangwu WHERE zwid<5";
		try {
			List<Object[]> list = qr.query(cpds.getConnection(),sql,new ArrayListHandler());
			for(Object[] obj:list) {
				System.out.println(obj[1]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
