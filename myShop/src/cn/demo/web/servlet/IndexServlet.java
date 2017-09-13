package cn.demo.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.demo.domain.Product;
import cn.demo.service.IndexSer;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static IndexSer is = new IndexSer();
       
    public IndexServlet() {
        super();
 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> listHot = null;
		List<Product> listNew = null;
		try {
			listHot = is.findHotProduct();
			listNew = is.findNewProduct();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Product product : listNew) {
			System.out.println(product);
		}
		request.setAttribute("listHot", listHot);
		request.setAttribute("listNew", listNew);
		request.getRequestDispatcher("index.jsp").forward(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
