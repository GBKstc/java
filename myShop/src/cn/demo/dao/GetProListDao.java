package cn.demo.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.demo.domain.Product;
import cn.demo.utils.DataSourceUtils;
import sun.java2d.d3d.D3DDrawImage;

public class GetProListDao {
	private static DataSource ds = DataSourceUtils.getDataSource();
	public List<Product> getPro(String cid, int num) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM product WHERE cid=? LIMIT ?,12";
		QueryRunner qr = new QueryRunner(ds);
		return qr.query(sql,new BeanListHandler<Product>(Product.class),cid,num);
	}

}
