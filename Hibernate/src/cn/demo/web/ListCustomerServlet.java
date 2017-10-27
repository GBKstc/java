package cn.demo.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.demo.domain.Customer;
import cn.demo.ser.CustomerSer;
import cn.demo.ser.CustomerSerImpl;

/**
 * Servlet implementation class ListCustomerServlet
 */
public class ListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerSer customerSer;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCustomerServlet() {
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
		List<Customer> listCustomerSer  = null;
		if(cust_name==null||cust_name.equals("")) {
			listCustomerSer = customerSer.listCustomerSer();
		}else {
			listCustomerSer = customerSer.listCustomerSer(cust_name);
		}
		
		request.setAttribute("list", listCustomerSer);
		request.getRequestDispatcher("jsp/customer/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
