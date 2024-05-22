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
		//���÷������˵�contenType���ͣ���JSPҳ���һ��
		response.setContentType("text/html; charset=UTF-8");
		//������Ӧ����
		response.setCharacterEncoding("UTF-8");
		 HttpSession session = request.getSession();
		 User user = (User) session.getAttribute("user");
		 if(user != null) {
             request.getRequestDispatcher("CatDisplay.jsp").forward(request, response);
		   // �Ự����'user'���ԣ��û��Ѿ�����֤
		   // �����û�����֤�����
		 } else {
	            response.sendRedirect("login.jsp?error=yes");
		 }
	       
	                // �û������ڣ���ת����¼ҳ�棬��ʾ������Ϣ	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
