package cn.demo.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.demo.domain.Orders;
import cn.demo.service.ProAdminSer;

/**
 * Servlet implementation class GetOrderList
 */
public class GetOrderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final ProAdminSer pad = new ProAdminSer();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOrderList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<Orders> list = pad.getOrderList();
			Gson gson = new Gson();
			System.out.println(list);
			response.getWriter().write(gson.toJson(list));
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
