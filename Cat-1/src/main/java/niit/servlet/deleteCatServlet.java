package niit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import niit.service.CatService;
import niit.service.impl.CatServicelmpl;

/**
 * Servlet implementation class deleteCatServlet
 */
@WebServlet("/deleteCatServlet")
public class deleteCatServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//设置服务器端的contenType类型：和JSP页面的一致
		response.setContentType("text/html; charset=UTF-8");
		//设置响应编码
		response.setCharacterEncoding("UTF-8");
		int catnum =Integer.parseInt(request.getParameter("catnum"));
		CatService service=new CatServicelmpl();
		boolean flag=  service.selectByCatnum(catnum);
		PrintWriter  out=response.getWriter();//相当于jsp的out对象
		if(flag) {
			 request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			out.print("删除失败！");
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
