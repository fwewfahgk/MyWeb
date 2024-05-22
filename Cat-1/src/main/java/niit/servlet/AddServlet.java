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
		//���÷������˵�contenType���ͣ���JSPҳ���һ��
		response.setContentType("text/html; charset=UTF-8");
		//������Ӧ����
		response.setCharacterEncoding("UTF-8");
		//2����ȡ�����ֶ�:��Ϊ���ڲ�ѯ���������ˣ���û�������ģ����Բ���Ҫ��ȡ�����ֶ�ֵ��
		//3������service�Ĳ�ѯ�����˵ķ���
		CatService service=new CatServicelmpl();
		ArrayList<Cat>  lists=  service.queryCatAll();
		//4������������תҳ��
		request.setAttribute("catList", lists);
		request.getRequestDispatcher("addcat.jsp").forward(request, response);
	
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
