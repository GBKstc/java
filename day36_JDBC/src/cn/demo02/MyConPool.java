package cn.demo02;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.*;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class MyConPool implements DataSource{
	private static List<Connection> list = new LinkedList<Connection>();
	
	static {
//		List<Connection> lista = new LinkedList<Connection>();
		for (int i = 0; i < 5; i++) {
			list.add(MysqlUtil.getConnection());
		}
//		list = lista;
	}
	
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		if(list.size()==0) {
			for (int i = 0; i < 5; i++) {
				list.add(MysqlUtil.getConnection());
			}
		}
		return list.remove(0);
	}

	public void backConnection(Connection con) {
		list.add(con);
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
