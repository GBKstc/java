package cn.demo01;

import java.sql.*;

public class HomeWork02 {
	
	public static void main(String[] args) throws Exception {
		Connection con = MySQLutil.getConnection();
//		function(con);
//		function_1(con);
		function_2(con);
	}

	private static void function_2(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		String mysql = "SELECT AVG(score) FROM student WHERE sex LIKE ?;";
		PreparedStatement pst = con.prepareStatement(mysql);
		pst.setString(1, "男");
		ShowData(pst.executeQuery());
		pst.setString(1, "女");
		ShowData(pst.executeQuery());
		pst.setString(1, "_");
		ShowData(pst.executeQuery());
	}

	private static void function_1(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		String mysql = "UPDATE student SET score=100 WHERE sex=\"男\"&&`name`LIKE\"%赵%\";";
	    PreparedStatement pst = con.prepareStatement(mysql); 
	    int rs = pst.executeUpdate();
	    System.out.println(rs);
	    MySQLutil.close(con, pst);
//	    while(rs.next()) {
//	    	System.out.println(rs.getString(2));
//	    }
		
	}

	private static void function(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		String mysql = "SELECT * FROM Student WHERE score>?&&sex=?;";
		PreparedStatement pst = con.prepareStatement(mysql);
		pst.setInt(1, 70);
		pst.setString(2, "女");
		ResultSet rs = pst.executeQuery();
		while(rs.next()){
			System.out.println(rs.getString("name")+" "+rs.getString("sex")+" "+rs.getString("score"));
		}
		
	}
	
	public static void ShowData(ResultSet rs) throws SQLException {
		while(rs.next()){
//			System.out.println(rs.getFetchSize());
			System.out.println(rs.getString(1));
		}
	}

}
