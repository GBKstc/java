package cn.demo.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import cn.demo.domain.Product;
import cn.demo.service.GetProListSer;

/**
 * Servlet implementation class GetProList
 */
public class GetProList extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static GetProListSer gpls = new GetProListSer();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetProList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cid = request.getParameter("cid");
		String page = request.getParameter("page");
		List<Product> list = null;
		try {
			list = gpls.getPro(cid,page);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("proList", list);
		request.getRequestDispatcher("product_list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
