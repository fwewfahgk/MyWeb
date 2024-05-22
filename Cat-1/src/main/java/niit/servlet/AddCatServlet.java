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
		//���÷������˵�contenType���ͣ���JSPҳ���һ��
		response.setContentType("text/html; charset=UTF-8");
		//������Ӧ����
		response.setCharacterEncoding("UTF-8");
		
		Map<String, String> map=imgname.imgFile(request, response);
		
		
		
		String name=map.get("name");//��ȡҳ����û���
		String breed=map.get("breed");//��ȡҳ����û���
		String sex=map.get("sex");//��ȡҳ������䣺�������ݿ��������int����
		int age=Integer.parseInt(map.get("age"));//���ַ���ageǿתΪint����age1
		String address=map.get("address");//��ȡҳ����Ա�
		String character=map.get("character");//��ȡҳ��ĵ�ַ
		String catnum1=map.get("catnum");
		//int catnum=Integer.parseInt(map.get("catnum"));
		//����ʹ��Student������Ϊ��װ����ʹ��
		String s = catnum1.substring(0, catnum1.lastIndexOf('.'));
		int catnum=Integer.parseInt(s);
		Cat stu=new Cat(name,breed,sex,age,address,character,catnum);
		CatService service=new CatServicelmpl();
		PrintWriter  out=response.getWriter();//�൱��jsp��out����
		if(service.addByCatnum(stu)) {
			   out.println("<script>alert('��ӳɹ���');location.href='"+request.getContextPath()+"/index.jsp'</script>");
		} else {
		    out.println("<script>alert('���ʧ�ܣ�');location.href='"+request.getContextPath()+"/catcatcat.jsp'</script>");
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
