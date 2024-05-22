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
        // 设置字符集
    	request.setCharacterEncoding("UTF-8");
		//设置服务器端的contenType类型：和JSP页面的一致
		response.setContentType("text/html; charset=UTF-8");
		//设置响应编码
		response.setCharacterEncoding("UTF-8");

        // 获取前端字段
        String userName = request.getParameter("usercode");
        String pwd = request.getParameter("password");
        String inputCode = request.getParameter("code");
        
        // 验证码判断
        String code = (String) request.getSession().getAttribute("captcha");
        if (inputCode == null || !inputCode.equalsIgnoreCase(code)) {
            // 验证码不正确，跳转到登录页面，提示错误信息
            response.sendRedirect("login.jsp?error=yes");
        } else {
            // 验证码正确，用户登录校验
            UserService service = new UserServiceImpl();
            User user = service.queryUser(userName, pwd);
            if (user == null) {
                // 用户不存在，跳转到登录页面，提示错误信息
                response.sendRedirect("login.jsp?error=yes");
            } else {
                // 用户存在，将用户信息保存在Session中，并跳转到成功页面
                
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