package niit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import niit.entity.User;
import niit.service.UserService;
import niit.service.impl.UserServiceImpl;

/**
 * Servlet implementation class CatDisplayServlet
 */
@WebServlet("/CatDisplayServlet")
public class CatDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//设置服务器端的contenType类型：和JSP页面的一致
		response.setContentType("text/html; charset=UTF-8");
		//设置响应编码
		response.setCharacterEncoding("UTF-8");
		 HttpSession session = request.getSession();
		 User user = (User) session.getAttribute("user");
		 if(user != null) {
             request.getRequestDispatcher("CatDisplay.jsp").forward(request, response);
		   // 会话中有'user'属性，用户已经被认证
		   // 处理用户已认证的情况
		 } else {
	            response.sendRedirect("login.jsp?error=yes");
		 }
	       
	                // 用户不存在，跳转到登录页面，提示错误信息	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
