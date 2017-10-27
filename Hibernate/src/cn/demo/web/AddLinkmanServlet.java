package cn.demo.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.demo.domain.Linkman;
import cn.demo.ser.CustomerSer;
import cn.demo.ser.CustomerSerImpl;

/**
 * Servlet implementation class AddLinkmanServlet
 */
public class AddLinkmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerSer customerSer;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddLinkmanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc = this.getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(sc);
		customerSer = (CustomerSer) wac.getBean("customerServer");
		// TODO Auto-generated method stub
		String cust_name = request.getParameter("cust_name");
		Map<String, String[]> map = request.getParameterMap();
		Linkman linkman = new Linkman();
		try {
			BeanUtils.populate(linkman, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customerSer.addLinkman(cust_name,linkman);
		response.sendRedirect(request.getContextPath()+"/listLinkmanServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
