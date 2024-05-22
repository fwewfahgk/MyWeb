package niit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import niit.entity.User;
import niit.service.UserService;
import niit.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//设置服务器端的contenType类型：和JSP页面的一致
		response.setContentType("text/html; charset=UTF-8");
		//设置响应编码
		response.setCharacterEncoding("UTF-8");
		//设置服务器端的contenType类型：和JSP页面的一致
		response.setContentType("text/html; charset=UTF-8");
		//设置响应编码
		response.setCharacterEncoding("UTF-8");
		// 从 HttpServletRequest 对象中获取 user 对象
		User user=  (User) request.getSession().getAttribute("user");
		Integer id=user.getId();
		String name=request.getParameter("name");//获取页面的用户名
		String pwd=request.getParameter("pwd");//获取密码
		User stu=new User(id,name,pwd);
		UserService service=new UserServiceImpl();
		PrintWriter  out=response.getWriter();//相当于jsp的out对象
		if(service.updateById(stu)) {
			 request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			out.print("添加失败！");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
