package cn.demo.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.demo.dao.ProAdminDao;
import cn.demo.domain.Orders;

public class ProAdminSer {
	private static ProAdminDao pad = new ProAdminDao();

	public List<Orders> getOrderList() throws SQLException {
		// TODO Auto-generated method stub
		return pad.getOrderList();
	}

	public List<Map<String, Object>> getOrderItems(String oid) throws SQLException {
		// TODO Auto-generated method stub
		return pad.getOrderItems(oid);
	}


}
