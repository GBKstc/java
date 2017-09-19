package cn.demo.web.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.demo.service.ProAdminSer;

/**
 * Servlet implementation class GetOrderItems
 */
public class GetOrderItems extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ProAdminSer pad = new ProAdminSer();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrderItems() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String oid = request.getParameter("oid");
		System.out.println(oid);
		Gson gson = new Gson();
		try {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(gson.toJson(pad.getOrderItems(oid)));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
