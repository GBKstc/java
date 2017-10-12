package cn.demo.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import cn.demo.domain.Customer;
import cn.demo.domain.Linkman;
import cn.demo.ser.CustomerSer;
import cn.demo.ser.CustomerSerImpl;
import cn.demo.utils.HibernateUtil;

/**
 * Servlet implementation class ListLinkmanServlet
 */
public class ListLinkmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerSer customerSer = new CustomerSerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListLinkmanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Session session = HibernateUtil.getCurrentSession();
//		Criteria createCriteria = session.createCriteria(Customer.class);
//		createCriteria
		DetachedCriteria dc = DetachedCriteria.forClass(Linkman.class);
		List<Linkman> list = customerSer.listLinkmanSer(dc);
		request.setAttribute("list", list);
		request.getRequestDispatcher("jsp/linkman/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
