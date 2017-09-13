package cn.demo.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.demo.domain.Category;
import cn.demo.utils.DataSourceUtils;

public class GetHeaderDao {
	private static DataSource ds = DataSourceUtils.getDataSource();

	public List<Category> getHeader() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM category";
		QueryRunner qr = new QueryRunner(ds);
		return qr.query(sql, new BeanListHandler<Category>(Category.class));
	}

}
