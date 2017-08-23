package cn.demol;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.sql.SQLException;
import java.util.Properties;

//import com.mysql.jdbc.Driver;

public class MysqlUtil {
	private MysqlUtil() {}
	public static Connection con;
	
	static {
		try {
			//注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//获取链接信息
			File file = new File("F:\\Java\\java\\properties\\mysql.properties");
			FileInputStream fis = new FileInputStream(file);
			Properties ppi = new Properties();
			ppi.load(fis);
//			System.out.println(ppi);
			String url = ppi.getProperty("url");
			String user = ppi.getProperty("user");
			String password = ppi.getProperty("password");
			//建立链接
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}

	public static Connection getConnection() {
		return con;
	}
	
	public static void close(Connection con,Statement st,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
			}
			if(st!=null) {
				st.close();
			}
			if(con!=null) {
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void close(Connection con,Statement st) {
		try {
			
			if(st!=null) {
				st.close();
			}
			if(con!=null) {
				con.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
