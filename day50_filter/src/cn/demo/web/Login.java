package cn.demo.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import cn.demo.Class.User;
import cn.demo.service.LoginSer;
import jdk.nashorn.internal.parser.JSONParser;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static LoginSer ls = new LoginSer();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String data = request.getParameter("data");
//		String password = request.getParameter("password");
		System.out.println(data);
		JSONObject  json = JSONObject.fromObject(data);
		JSONObject jsonData = json.getJSONObject("data");
		System.out.println(jsonData.getString("username"));
//		System.out.println();
//		User user = ls.userLogin(username,password);
//		Gson gs = new Gson();
//		String str = gs.toJson(user);
//		response.getWriter().write(str);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
