package cn.demo.login;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;

import cn.demo.object.User;
import cn.demo.utils.DataSourceUtils;

/**
 * Servlet implementation class CnRegister
 */
public class CnRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CnRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.setContentType("text/html;charset=UTF-8");
//		response.getWriter().write("西瓜");
//		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
//		requestDispatcher.forward(request, response);4
		request.setCharacterEncoding("utf-8");
		Map<String, String[]> parameterMap = request.getParameterMap();
		User user = new User();
		try {
			BeanUtils.populate(user, parameterMap);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user.getCode().equals(request.getSession().getAttribute("verify"))) {
			user.setUid(UUID.randomUUID().toString());
			String reg = registerUser(user);
			if(reg.split("=")[1].equals("1")) {
				response.sendRedirect(request.getContextPath()+"/login.jsp");
			}else {
				response.getWriter().write("Fail!");
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
			request.setAttribute("word", "验证码错误");
			rd.forward(request, response);
		}
		
		
	}

	private String registerUser(User user) {
		// TODO Auto-generated method stub
		Connection con = null;
		try {
		    con = DataSourceUtils.getConnection();
		    String sql = "INSERT INTO `user` VALUES(?,?,?,?,?,?,?,?,?,?);";
		    Object[] param = {user.getUid(),user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getTelephone(),user.getBirthday(),user.getSex(),user.getState(),user.getCode()};
//		    for (int s = 0; s < param.length; s++) {
//				System.out.println(param[s]);
//			}
		    QueryRunner qr = new QueryRunner();
		    int update = qr.update(con, sql, param);
		    
		    return user.getName()+"="+update;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("注册报错");
		}
//		return null;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
