package cn.gjp.controller;

import java.util.List;

import cn.gjp.domain.ZhangWu;
import cn.gjp.serivice.ZhangWuService;

/**
 * 接受视图层
 * 传给Service
 * @author Administrator
 *
 */

public class ZhangWuController {
	
	public ZhangWuService zws = new ZhangWuService();
	
	public List<ZhangWu> selectAll() {
		
		return zws.selectAll();
		
	}

	public List<ZhangWu> select(String dataStart, String dataEnd) {
		// TODO Auto-generated method stub
		return zws.select(dataStart, dataEnd);
	}

	public int addZhangWu(ZhangWu zw) {
		// TODO Auto-generated method stub
		return zws.addZhangWu(zw);
	}

	public int editZhangWu(ZhangWu zw) {
		// TODO Auto-generated method stub
		return zws.editZhangWu(zw);
	}

	public int deleteZhangWu(int zwid) {
		// TODO Auto-generated method stub
		return zws.deleteZhangWu(zwid);
	}


}
