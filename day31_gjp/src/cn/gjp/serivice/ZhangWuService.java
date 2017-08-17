package cn.gjp.serivice;
import java.util.List;

import cn.gjp.dao.*;
import cn.gjp.domain.ZhangWu;
/**
 * 业务层
 * 接收controller
 * 调用dao层
 * @author Administrator
 *
 */

public class ZhangWuService {

	private ZhangWuDao dao = new ZhangWuDao();
	
	public List<ZhangWu> selectAll() {
		
		return dao.selectAll();
	
	}

	public List<ZhangWu> select(String dataStart, String dataEnd) {
		// TODO Auto-generated method stub
		return dao.select(dataStart, dataEnd);
	}

	public int addZhangWu(ZhangWu zw) {
		// TODO Auto-generated method stub
		return dao.addZhangWu(zw);
	}

	public int editZhangWu(ZhangWu zw) {
		// TODO Auto-generated method stub
		return dao.editZhangWu(zw);
	}

	public int deleteZhangWu(int zwid) {
		// TODO Auto-generated method stub
		return dao.editZhangWu(zwid);
	}
	
}
