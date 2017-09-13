package cn.demo.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.demo.domain.Product;
import cn.demo.utils.DataSourceUtils;

public class IndexDao {
	private static DataSource ds = DataSourceUtils.getDataSource();
	//获得最热商品
	public List<Product> findHotProduct() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM product WHERE is_hot=1 ORDER BY pdate DESC LIMIT 0,9";
		QueryRunner qr = new QueryRunner(ds);
		return qr.query(sql, new BeanListHandler<Product>(Product.class));
	}
	//获得最新商品
	public List<Product> findNewProduct() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM product ORDER BY pdate DESC LIMIT 0,9";
		QueryRunner qr = new QueryRunner(ds);
		return qr.query(sql, new BeanListHandler<Product>(Product.class));
	}

}
