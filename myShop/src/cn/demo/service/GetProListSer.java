package cn.demo.service;

import java.sql.SQLException;
import java.util.List;

import cn.demo.dao.GetProListDao;
import cn.demo.domain.Product;

public class GetProListSer {
	private static GetProListDao gpld = new GetProListDao();
	public List<Product> getPro(String cid, String page) throws SQLException {
		// TODO Auto-generated method stub
		int num = (Integer.parseInt(page)-1)*12;
		return gpld.getPro(cid,num);
	}

}
