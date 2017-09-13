package cn.demo.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.demo.domain.Category;
import cn.demo.service.GetHeaderSer;
import sun.security.provider.certpath.OCSPResponse.ResponseStatus;

/**
 * Servlet implementation class GetHeader
 */
public class GetHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static GetHeaderSer ghs = new GetHeaderSer();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetHeader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> list = null;
		try {
			list = ghs.getHeader();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
