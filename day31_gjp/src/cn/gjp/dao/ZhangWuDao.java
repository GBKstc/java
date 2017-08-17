package cn.gjp.dao;

import java.util.List;

//import javax.sql.DataSource;

import org.apache.commons.dbutils.handlers.BeanListHandler;

import org.apache.commons.dbutils.QueryRunner;

import cn.gjp.domain.ZhangWu;
import cn.gjp.tools.MysqlUtil;

/**
 * 数据增删改查
 * @author Administrator
 *
 */
public class ZhangWuDao {
	
	public QueryRunner qr = new QueryRunner(MysqlUtil.getDataSource());
	
	public List<ZhangWu> selectAll() {
		
		String sql = "SELECT * FROM gjp_zhangwu;";
		try {
//			System.out.println(qr.query(sql,new BeanListHandler<ZhangWu>(ZhangWu.class)));
			return qr.query(sql,new BeanListHandler<ZhangWu>(ZhangWu.class));
			
		}catch(Exception ex){
			System.out.println(ex);
			throw new RuntimeException("查询所有账务失败");
		}
		
	}

	public List<ZhangWu> select(String dataStart, String dataEnd) {
		// TODO Auto-generated method stub
		String sql = 
				"SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?;";
		Object[] params = {dataStart,dataEnd};
		try {
			return qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class), params);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			throw new RuntimeException("条件查询出错了");
		}
		
	}

	public int addZhangWu(ZhangWu zw) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO gjp_zhangwu (flname,money,zhanghu,createtime,description) VALUES (?,?,?,?,?);";
		Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
		try {
			return qr.update(sql, params);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			throw new RuntimeException("添加错误");
		}
		
	}

	public int editZhangWu(ZhangWu zw) {
		// TODO Auto-generated method stub
		String sql = "UPDATE gjp_zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? WHERE zwid=?;";
		Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
		try {
			return qr.update(sql, params);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			throw new RuntimeException("修改错误");
		}
	}

	public int editZhangWu(int zwid) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM gjp_zhangwu WHERE zwid=?;";
		try {
			return qr.update(sql,zwid);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			throw new RuntimeException("删除错误");
		}
		
	}
	
}
