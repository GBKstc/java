package cn.demo.service;

import java.sql.SQLException;
import java.util.List;

import cn.demo.dao.GetHeaderDao;
import cn.demo.domain.Category;

public class GetHeaderSer {
	private static GetHeaderDao  ghd = new GetHeaderDao();
	public List<Category> getHeader() throws SQLException {
		// TODO Auto-generated method stub
		return ghd.getHeader();
	}

}
