package cn.demo04;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;

public class HomeWork {
	
	private static DataSource dataSource;
	
	public static void main(String[] args) {
		
		InputStream is = HomeWork.class.getClassLoader().getResourceAsStream("jdbc.properties");
		
		Properties pps = new Properties();
		String sql = "SELECT * FROM gjp_zhangwu WHERE zwid<5";
		try {
			pps.load(is);
			dataSource = BasicDataSourceFactory.createDataSource(pps);
			Connection con = dataSource.getConnection();
			QueryRunner qr = new QueryRunner();
			List<Object[]> list = qr.query(con, sql, new ArrayListHandler());
			for(Object [] obj:list) {
				System.out.println(obj[1]);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
