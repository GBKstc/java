package cn.demo01;

import java.sql.*;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;

//import com.mysql.jdbc.PreparedStatement;
//import java.sql.SQLException;

//import com.mysql.jdbc.Driver;

public class HomeWork01 {
	public static void main(String[] args) throws Exception {
		//注册驱动
//		DriverManager.registerDriver(new Driver());
		Class.forName("com.mysql.jdbc.Driver");
		//获取链接
		String myUrl = "jdbc:mysql://localhost:3306/javatest?characterEncoding=UTF-8"; 
		String myUser = "root"; 
		String myPassword = ""; 
		Connection con = DriverManager.getConnection(myUrl, myUser, myPassword);
//		System.out.println(con);
		//获得语句实现平台
//		Statement stm = con.createStatement();
//		String mysql1 = "";
//		int a = stm.executeUpdate("INSERT INTO student (name,sex,score) VALUES (\"李少荣\",\"女\",80),(\"赵凯\",\"男\",75),(\"周强\",\"男\",95),(\"王晓婷\",\"女\",55),\r\n" + 
//				"(\"李少荣\",\"女\",80),(\"张秀花\",\"女\",68),(\"顾会\",\"女\",50),(\"赵天一\",\"男\",32);");
//		System.out.println(a);
		PreparedStatement pst = con.prepareStatement("SELECT * FROM student;");
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("name")+" "+" "+rs.getString("sex")+" "+rs.getString("score"));
		}
		rs.close();
		pst.close();
		con.close();
	}

}
