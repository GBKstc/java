package cn.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import cn.demo.util.MyThread;

/**
 * Servlet implementation class Transfer
 */
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static cn.demo.service.Transfer service  = new cn.demo.service.Transfer();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transfer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("text/xml;charset=utf-8");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		double num = Double.parseDouble(request.getParameter("num"));
		String out = request.getParameter("out");
		String put = request.getParameter("put");
//		System.out.println(num);
//		System.out.println(out);
//		System.out.println(put);
		service.transfer(num,out,put);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(out);
		MyThread mytd = new MyThread();
		Thread td = new Thread(mytd);
		td.start();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
