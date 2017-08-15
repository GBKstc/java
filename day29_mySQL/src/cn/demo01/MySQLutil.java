package cn.demo01;
import java.io.*;
import java.sql.*;
import java.util.Properties;

//import com.mysql.jdbc.Driver;

public class MySQLutil {
	private MySQLutil() {}
	public static Connection getConnection() throws ClassNotFoundException, SQLException, Exception {
		//注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//获取连接数据
		File file = new File("F:\\Java\\java\\properties\\mysql.properties");
//		System.out.println(file);
		FileInputStream fis = new FileInputStream(file);
		Properties pps = new Properties();
		pps.load(fis);
//		String url = pps.getProperty("url");
		//建立连接
		String url = pps.getProperty("url");
		String user = pps.getProperty("user");
		String password = pps.getProperty("password");
		Connection con = DriverManager.getConnection(url, user, password);
		//返回接口
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
