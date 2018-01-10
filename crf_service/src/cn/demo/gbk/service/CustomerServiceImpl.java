package cn.demo.gbk.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cn.demo.gbk.domain.Customer;

public class CustomerServiceImpl implements CustomerService {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public List<Customer> findAll() {
		String sql = "SELECT * FROM t_customer";
		List<Customer> list = jdbcTemplate.query(sql,new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");
				Customer cust = new Customer(id, name, station, telephone, address, decidedzone_id);
				return cust;
			}
			
		});
		return list;
	}
	@Override
	public List<Customer> findNotBindingList() {
		String sql = "SELECT * FROM t_customer WHERE decidedzone_id IS NULL";
		List<Customer> list = jdbcTemplate.query(sql,new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");
				Customer cust = new Customer(id, name, station, telephone, address, decidedzone_id);
				return cust;
			}
			
		});
		return list;
	}
	@Override
	public List<Customer> findHasBindingList(String decidedzone_id) {
		String sql = "SELECT * FROM t_customer WHERE decidedzone_id = ?";
		List<Customer> list = jdbcTemplate.query(sql,new RowMapper<Customer>() {

			@Override
			public Customer mapRow(ResultSet rs, int arg1) throws SQLException {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String station = rs.getString("station");
				String telephone = rs.getString("telephone");
				String address = rs.getString("address");
				String decidedzone_id = rs.getString("decidedzone_id");
				Customer cust = new Customer(id, name, station, telephone, address, decidedzone_id);
				return cust;
			}
			
		},decidedzone_id);
		return list;
	}
	@Override
	public void saveCustomer(List<Customer> list, String decidedzone_id) {
		String sql = "UPDATE t_customer SET decidedzone_id = NULL WHERE decidedzone_id = ?";
		jdbcTemplate.update(sql,decidedzone_id);
		String sql2 = "UPDATE t_customer SET decidedzone_id = ? WHERE id = ?";
		for (Customer customer : list) {
			jdbcTemplate.update(sql2, decidedzone_id,customer.getId());
		}
	}

}
