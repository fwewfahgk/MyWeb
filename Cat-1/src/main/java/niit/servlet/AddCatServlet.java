package niit.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import imgname.imgname;
import niit.entity.Cat;
import niit.service.CatService;
import niit.service.impl.CatServicelmpl;

/**
 * Servlet implementation class AddCatServlet
 */
@WebServlet("/AddCatServlet")
public class AddCatServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//设置服务器端的contenType类型：和JSP页面的一致
		response.setContentType("text/html; charset=UTF-8");
		//设置响应编码
		response.setCharacterEncoding("UTF-8");
		
		Map<String, String> map=imgname.imgFile(request, response);
		
		
		
		String name=map.get("name");//获取页面的用户名
		String breed=map.get("breed");//获取页面的用户名
		String sex=map.get("sex");//获取页面的年龄：但是数据库的年龄是int类型
		int age=Integer.parseInt(map.get("age"));//将字符串age强转为int类型age1
		String address=map.get("address");//获取页面的性别
		String character=map.get("character");//获取页面的地址
		String catnum1=map.get("catnum");
		//int catnum=Integer.parseInt(map.get("catnum"));
		//可以使用Student对象作为封装数据使用
		String s = catnum1.substring(0, catnum1.lastIndexOf('.'));
		int catnum=Integer.parseInt(s);
		Cat stu=new Cat(name,breed,sex,age,address,character,catnum);
		CatService service=new CatServicelmpl();
		PrintWriter  out=response.getWriter();//相当于jsp的out对象
		if(service.addByCatnum(stu)) {
			   out.println("<script>alert('添加成功！');location.href='"+request.getContextPath()+"/index.jsp'</script>");
		} else {
		    out.println("<script>alert('添加失败！');location.href='"+request.getContextPath()+"/catcatcat.jsp'</script>");
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
