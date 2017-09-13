package cn.demo.service;

import java.sql.SQLException;
import java.util.List;

import cn.demo.dao.IndexDao;
import cn.demo.domain.Product;

public class IndexSer {
	private static IndexDao id = new IndexDao();

	public List<Product> findHotProduct() throws SQLException {
		// TODO Auto-generated method stub
		return id.findHotProduct();
	}

	public List<Product> findNewProduct() throws SQLException {
		// TODO Auto-generated method stub
		return id.findNewProduct();
	}

}
