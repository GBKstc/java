package cn.demo.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import cn.demo.service.CheckUsernameSer;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class CheckUsername
 */
public class CheckUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final CheckUsernameSer cus = new CheckUsernameSer();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUsername() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
//		JSONObject json = JSONObject.fromObject(data);
//		Gson gs = new Gson();
//		String jsonStr = gs.toJson(cus.check(username));
		if(cus.check(username).size()==1) {
			response.getWriter().write("{\"data\":"+true+"}");
		}else {
			response.getWriter().write("{\"data\":"+false+"}");
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
