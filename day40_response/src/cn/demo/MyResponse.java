package cn.demo;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyResponse
 */
public class MyResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyResponse() {
        super();
     
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		response.getWriter().write("开始!");
//		response.setStatus(302);
//		response.addHeader("name", "GBK");
//		response.setHeader("name", "XG");
		String realPath = 
				this.getServletContext().getRealPath("西瓜.png");
		response.setContentType(this.getServletContext().getMimeType("西瓜.png"));
		response.setHeader("Content-Disposition", "attachment;filename="+"西瓜.png");
		
		FileInputStream fis = new FileInputStream(realPath);
		ServletOutputStream os = response.getOutputStream();
		int len = 0;
		byte[] data = new byte[1024];
		while((len = fis.read(data))!=-1) {
			os.write(data, 0, len);
		}
		fis.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
