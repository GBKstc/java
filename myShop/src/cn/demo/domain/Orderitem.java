package cn.demo.domain;

public class Orderitem {
	
	private String itemid;
	//单个商品数量
	private int count;
	//单个商品总价
	private double subtotal;
//	//商品ID
//	private String pid;
	//商品
	private Product product;
	//订单对象
	private Orders orders;
	
	
	
	public Orderitem() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Orderitem(String itemid, int count, double subtotal, Product product, Orders orders) {
		super();
		this.itemid = itemid;
		this.count = count;
		this.subtotal = subtotal;
		this.product = product;
		this.orders = orders;
	}



	public String getItemid() {
		return itemid;
	}



	public void setItemid(String itemid) {
		this.itemid = itemid;
	}



	public int getCount() {
		return count;
	}



	public void setCount(int count) {
		this.count = count;
	}



	public double getSubtotal() {
		return subtotal;
	}



	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public Orders getOrders() {
		return orders;
	}



	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	
	

}
