package cn.demo.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.demo.domain.Cart;
import cn.demo.domain.CartItem;

/**
 * Servlet implementation class DeleteCartList
 */
public class DeleteCartList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCartList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pid = request.getParameter("pid");
		HttpSession session = request.getSession();
		if(pid!=null) {
			
			Cart cart = (Cart) session.getAttribute("cart");
			Map<String, CartItem> map = cart.getCartItems();
			cart.setTotal(cart.getTotal()-map.get(pid).getSubtotal());
			map.remove(pid);
		}else{
			session.removeAttribute("cart");
		};
		
		response.sendRedirect("cart.jsp");
//		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
