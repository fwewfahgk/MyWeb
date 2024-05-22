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
		//���÷������˵�contenType���ͣ���JSPҳ���һ��
		response.setContentType("text/html; charset=UTF-8");
		//������Ӧ����
		response.setCharacterEncoding("UTF-8");
		//���÷������˵�contenType���ͣ���JSPҳ���һ��
		response.setContentType("text/html; charset=UTF-8");
		//������Ӧ����
		response.setCharacterEncoding("UTF-8");
		// �� HttpServletRequest �����л�ȡ user ����
		User user=  (User) request.getSession().getAttribute("user");
		Integer id=user.getId();
		String name=request.getParameter("name");//��ȡҳ����û���
		String pwd=request.getParameter("pwd");//��ȡ����
		User stu=new User(id,name,pwd);
		UserService service=new UserServiceImpl();
		PrintWriter  out=response.getWriter();//�൱��jsp��out����
		if(service.updateById(stu)) {
			 request.getRequestDispatcher("login.jsp").forward(request, response);
		}else {
			out.print("���ʧ�ܣ�");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
