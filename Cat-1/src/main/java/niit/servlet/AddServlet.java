package niit.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import niit.entity.Cat;
import niit.service.CatService;
import niit.service.impl.CatServicelmpl;

/**
 * Servlet implementation class AllCatServlset
 */
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//设置服务器端的contenType类型：和JSP页面的一致
		response.setContentType("text/html; charset=UTF-8");
		//设置响应编码
		response.setCharacterEncoding("UTF-8");
		//2、获取请求字段:因为现在查询的是所有人，是没有条件的，所以不需要获取请求字段值了
		//3、调用service的查询所有人的方法
		CatService service=new CatServicelmpl();
		ArrayList<Cat>  lists=  service.queryCatAll();
		//4、处理结果并跳转页面
		request.setAttribute("catList", lists);
		request.getRequestDispatcher("addcat.jsp").forward(request, response);
	
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
