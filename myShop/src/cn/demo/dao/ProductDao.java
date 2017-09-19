package cn.demo.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;

import cn.demo.domain.Orderitem;
import cn.demo.domain.Orders;
import cn.demo.domain.Product;
import cn.demo.utils.DataSourceUtils;

public class ProductDao {
	private static DataSource ds = DataSourceUtils.getDataSource();

	public Product getProInfo(String pid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qr = new QueryRunner(ds);
		String sql = "SELECT * FROM product WHERE pid=?";
		return qr.query(sql, new BeanHandler<Product>(Product.class),pid);
		
	}

	public void orderForm(Orders order) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = DataSourceUtils.getConnection();
		try {
			conn.setAutoCommit(false);
			addOrder(order, conn);
			List<Orderitem> list = order.getList();
			for (Orderitem orderitem : list) {
				addOrderItem(orderitem, conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			conn.rollback();
			e.printStackTrace();
		}finally {
			conn.commit();
		}
		
		
	}
	
	public void  addOrder(Orders order,Connection conn) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
		System.out.println(order.getOrdertime());
		qr.update(conn,sql, order.getOid(),order.getOrdertime(),order.getTotal(),order.getState(),
				order.getAddress(),order.getName(),order.getTelephone(),order.getUser().getUid());
	}
	
	public void  addOrderItem(Orderitem item,Connection conn) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "insert into orderitem values(?,?,?,?,?)";
		qr.update(conn,sql,item.getItemid(),item.getCount(),item.getSubtotal(),item.getProduct().getPid(),item.getOrders().getOid());
	}

}
