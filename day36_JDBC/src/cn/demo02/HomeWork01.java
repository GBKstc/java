package cn.demo02;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeWork01 {
	private static MyConPool mcp = new MyConPool();
	public static void main(String[] args) {
//		MyConPool mcp = new MyConPool();
		Connection  con = mcp.getConnection();
		String sql = "SELECT * FROM gjp_zhangwu WHERE zwid<5";
		try {
			java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getObject("flname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			mcp.backConnection(con);
		}
	}
	

}
