package cn.demo.domain;

import java.util.Date;
import java.util.List;

public class Orders {
	private String oid;//订单ID
	private Date ordertime;//下单时间
	private double total;//总价
	private int state;//订单状态
	private String address;//收货地址
	private String name;//收货人
	private String telephone;//收货电话
	private User user;//下单用户
	private List<Orderitem> list; //订单包含的商品
	
	
	
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Orders(String oid, Date ordertime, double total, int state, String address, String name, String telephone,
			User user, List<Orderitem> list) {
		super();
		this.oid = oid;
		this.ordertime = ordertime;
		this.total = total;
		this.state = state;
		this.address = address;
		this.name = name;
		this.telephone = telephone;
		this.user = user;
		this.list = list;
	}



	public String getOid() {
		return oid;
	}



	public void setOid(String oid) {
		this.oid = oid;
	}



	public Date getOrdertime() {
		return ordertime;
	}



	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}



	public double getTotal() {
		return total;
	}



	public void setTotal(double total) {
		this.total = total;
	}



	public int getState() {
		return state;
	}



	public void setState(int state) {
		this.state = state;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public List<Orderitem> getList() {
		return list;
	}



	public void setList(List<Orderitem> list) {
		this.list = list;
	}
	
	
	
}
