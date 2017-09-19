package cn.demo.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.demo.dao.ProductDao;
import cn.demo.domain.Cart;
import cn.demo.domain.CartItem;
import cn.demo.domain.Orderitem;
import cn.demo.domain.Orders;
import cn.demo.domain.Product;
import cn.demo.domain.User;
import cn.demo.utils.CommonsUtils;

public class ProductSer {
	private static ProductDao pro = new ProductDao();
	
	public Product getProInfo(String pid) throws SQLException {
		// TODO Auto-generated method stub
		return pro.getProInfo(pid);
	}

	public void orderForm(Cart cart,User user1) throws SQLException  {
		
		//创建Orders对象
		String oid = CommonsUtils.getUUID();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		Date ordertime = new Date();
//		sdf.format(ordertime);
		
		double total = cart.getTotal();
		int state = 0;
		String address = null;
		String name = null;
		String telephone = null;
		User user = user1;
		List<Orderitem> list = new ArrayList<Orderitem>();
		Map<String, CartItem> map = cart.getCartItems();
		Set<String> set = map.keySet();
		Orders order = new Orders(oid,ordertime,total,state,address,
				name,telephone,user,list);
		for (Iterator<String> iterator = set.iterator(); iterator.hasNext();) {
			CartItem cartItem = map.get(iterator.next());
			System.out.println(cartItem);
			String itemid = CommonsUtils.getUUID();
			int count = cartItem.getBuyNum();
			double subtotal = cartItem.getSubtotal();
			Product product = cartItem.getProduct();
			Orders orders = order;
			Orderitem orderitem = new Orderitem(itemid,count,subtotal,product,
					orders);
			list.add(orderitem);
		}
		
		pro.orderForm(order);
		
		
	}
	

}
