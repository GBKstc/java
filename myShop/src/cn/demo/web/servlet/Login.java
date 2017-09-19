package cn.demo.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import cn.demo.domain.User;
import cn.demo.service.LoginSer;
import cn.demo.utils.CommonsUtils;
import javafx.scene.chart.PieChart.Data;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final LoginSer ls = new LoginSer();
	
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = null;
		try {
			System.out.println("login");
			user = ls.login(username,password);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			String url = CommonsUtils.getCookieValue(request.getCookies(), "Referer");
			if(url==null) {
				url="myShop/main.jsp";
			}
			System.out.println(url);
			response.sendRedirect(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
