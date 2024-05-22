package Filter;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    private ServletContext context;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.context = filterConfig.getServletContext();
        this.context.log("LoginFilter initialized");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        HttpSession session = request.getSession(false); // 不创建新Session, 返回当前Session 或 null

        if (session == null || session.getAttribute("user") == null) { // 如果用户未登录
            this.context.log("Unauthorized access request from: " + request.getRemoteAddr());

            response.sendRedirect(request.getContextPath() + "/login.jsp"); // 重定向到登录页面
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // close any resources here
    }
}