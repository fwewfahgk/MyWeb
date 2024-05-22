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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // �����ַ���
    	request.setCharacterEncoding("UTF-8");
		//���÷������˵�contenType���ͣ���JSPҳ���һ��
		response.setContentType("text/html; charset=UTF-8");
		//������Ӧ����
		response.setCharacterEncoding("UTF-8");

        // ��ȡǰ���ֶ�
        String userName = request.getParameter("usercode");
        String pwd = request.getParameter("password");
        String inputCode = request.getParameter("code");
        
        // ��֤���ж�
        String code = (String) request.getSession().getAttribute("captcha");
        if (inputCode == null || !inputCode.equalsIgnoreCase(code)) {
            // ��֤�벻��ȷ����ת����¼ҳ�棬��ʾ������Ϣ
            response.sendRedirect("login.jsp?error=yes");
        } else {
            // ��֤����ȷ���û���¼У��
            UserService service = new UserServiceImpl();
            User user = service.queryUser(userName, pwd);
            if (user == null) {
                // �û������ڣ���ת����¼ҳ�棬��ʾ������Ϣ
                response.sendRedirect("login.jsp?error=yes");
            } else {
                // �û����ڣ����û���Ϣ������Session�У�����ת���ɹ�ҳ��
                
            	request.getSession().setAttribute("user", user);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}