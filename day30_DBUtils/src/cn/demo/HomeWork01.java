package cn.demo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.omg.CORBA.BooleanHolder;

public class HomeWork01 {
	private static Connection con  = MysqlUtil.getConnection();
	
	public static void main(String[] args) throws SQLException{
		
		changeMysql();
		ArrayHandlerDemo();
		ArrayListHandlerDmeo();
		BeanHangleDemo();
		
		
	}

	private static void BeanHangleDemo() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM student WHERE score>90;";
		Sort so = qr.query(con, sql ,new BeanHandler<Sort>(Sort.class));
		System.out.println(so);
	}

	private static void ArrayListHandlerDmeo() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM student WHERE score>90;";
		List<Object[]> list = qr.query(con, sql ,new ArrayListHandler());
		System.out.println(list);
		for(Object[] obj:list) {
			System.out.println(obj);
		}
	}

	private static void ArrayHandlerDemo() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql = "SELECT * FROM student WHERE score>90;";
		Object[] arr = qr.query(con, sql, new ArrayHandler());
		for(Object obj:arr) {
			System.out.print(obj+"\t");
		}
	}

	private static void changeMysql() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner();
		String sql = "UPDATE student SET score=? WHERE `name` LIKE \"%李%\"";
		Object[] arr = {88};
		int a = qr.update(con, sql, arr);
		System.out.println(a);
//		DbUtils.closeQuietly(con);
	}
	
	
	
	
	
}
