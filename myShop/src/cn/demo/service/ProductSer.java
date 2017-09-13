package cn.demo.service;

import java.sql.SQLException;

import cn.demo.dao.ProductDao;
import cn.demo.domain.Product;

public class ProductSer {
	private static ProductDao pro = new ProductDao();
	
	public Product getProInfo(String pid) throws SQLException {
		// TODO Auto-generated method stub
		return pro.getProInfo(pid);
	}
	

}
