package cn.demo.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import cn.demo.domain.Orders;
import cn.demo.utils.DataSourceUtils;

public class ProAdminDao {
	private static DataSource ds = DataSourceUtils.getDataSource();

	public List<Orders> getOrderList() throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(ds);
		String sql = "SELECT * FROM orders;";
		return qr.query(sql, new BeanListHandler<Orders>(Orders.class));
	}

	public List<Map<String, Object>> getOrderItems(String oid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(ds);
		String sql = "SELECT o.*,p.pname,p.shop_price,p.pimage\r\n" + 
				"FROM orderitem o,product p\r\n" + 
				"WHERE o.pid=p.pid AND o.oid=?";
		return qr.query(sql, new MapListHandler(),oid);
	}

}
