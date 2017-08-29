package cn.demo.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.demo.object.User;
import cn.demo.utils.DataSourceUtils;

/**
 * Servlet implementation class CnLogin
 */
public class CnLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CnLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		username = new String(username.getBytes("iso8859-1"),"utf-8");
		String password = request.getParameter("password");
		User user = loginUser(username,password);
		if(user!=null) {
			request.setAttribute("word", "登陆成功");
		}else {
			request.setAttribute("word", "登陆失败");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		rd.forward(request, response);
	}

	private User loginUser(String username, String password) {
		// TODO Auto-generated method stub
//		Connection con = null;
		String sql = "SELECT * FROM `user` WHERE username=?&&`password`=?";
		QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		
		try {
			return qr.query(sql, new BeanHandler<User>(User.class), username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("登陆出错");
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
