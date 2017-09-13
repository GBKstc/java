package cn.demo.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

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

}
