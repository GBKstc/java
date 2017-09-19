package cn.demo.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.demo.domain.Cart;
import cn.demo.domain.CartItem;
import cn.demo.domain.User;
import cn.demo.service.ProductSer;

/**
 * Servlet implementation class OrderForm
 */
public class OrderForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProductSer ps = new ProductSer();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null) {
			System.out.println(request.getHeader("Referer"));
//			Cookie[] cookies = request.getCookies();
			Cookie requestURI = new Cookie("Referer", request.getHeader("Referer"));
			response.addCookie(requestURI);
//			request.setAttribute("requestURI", request.getRequestURI());
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return ;
		}
		
		Cart cart = (Cart)session.getAttribute("cart");
		User user = (User)session.getAttribute("user");
		try {
			ps.orderForm(cart,user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath()+"/order_info.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
