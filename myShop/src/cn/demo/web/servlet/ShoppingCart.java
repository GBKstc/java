package cn.demo.web.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.demo.domain.Cart;
import cn.demo.domain.CartItem;
import cn.demo.domain.Product;

/**
 * Servlet implementation class ShoppingCart
 */
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int buyNum = Integer.parseInt(request.getParameter("buyNum"));
		Object obj = session.getAttribute("pro");
		//有商品在session
		if(obj!=null) {
			Product pro = (Product)obj;
			double newSubtotal = pro.getShop_price()*buyNum;
//			CartItem cartitem = new CartItem(pro,buyNum,subtotal);
			Object cartObj = session.getAttribute("cart");
			//购物车里原来有商品
			if(cartObj!=null) {
				Cart cart = (Cart)cartObj;
				Map<String, CartItem> map = cart.getCartItems();
				//购物车里有此商品
				System.out.println(pro.getPname()+"是"+map.containsKey(pro.getPid()));
				if(map.containsKey(pro.getPid())) {
					CartItem cartitem = map.get(pro.getPid());
					cartitem.setBuyNum(cartitem.getBuyNum()+buyNum);
					cartitem.setSubtotal(cartitem.getSubtotal()+newSubtotal);
				}else {
					CartItem cartitem = new CartItem(pro,buyNum,newSubtotal);
					map.put(pro.getPid(), cartitem);
				}
				//重新设置Map
				cart.setCartItems(map);
				//重新计算总价
				cart.setTotal(cart.getTotal()+newSubtotal);
			}else {
				Cart cart = new Cart();
				cart.setTotal(newSubtotal);
				CartItem cartitem = new CartItem(pro,buyNum,newSubtotal);
				Map<String, CartItem> map = new HashMap<String, CartItem>();
				map.put(pro.getPid(), cartitem);
				cart.setCartItems(map);
				session.setAttribute("cart",cart);
			}
			session.removeAttribute("pro");
		}
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
