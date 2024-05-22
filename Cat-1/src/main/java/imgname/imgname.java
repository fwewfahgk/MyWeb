package imgname;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class imgname {
	public static Map<String,String> imgFile(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out=response.getWriter();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		String uploadFilePath=request.getServletContext().getRealPath("/img");
		
		if(isMultipart) {
			//newһ�� map��������ͼƬ������ͨ����ֵ
			HashMap<String,String> map=new HashMap<String, String>();
			DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            //�����ϴ��ļ���С����λ byte
            upload.setSizeMax(1024*1024*4);
            try {
                // ����form���������ļ�
                List<FileItem> items = upload.parseRequest(request);
                for (FileItem item : items) {
                    // ��ͨ���ֶ�true, �ļ����ֶ�false
                    if (!item.isFormField()) {
                        //�ļ���
                        String fileName = item.getName();
                        if (fileName != null || !"".equals(fileName)) {
                            //String s = fileName.substring(fileName.lastIndexOf('.'));
                            String s1 = fileName.substring(fileName.lastIndexOf('.')+1);
                           boolean a=s1.equals("jpg")||s1.equals("jpeg")||s1.equals("png");
                            if (!a) {
                                // ��ת·�� 
                                out.print("<script>alert('�ļ���ʽ����ȷ��ֻ���ϴ�jpg��gif��jpeg��pngͼƬ');window.location.href='/catcatcat.jsp'</script>");
                            } else {
                                // �����ļ�ͬ�������⣬���ļ���ǰ���UUID
                               File saveFile = new File(uploadFilePath,fileName);
                                //�ϴ�
                                item.write(saveFile);
                                // �ļ���
                                String homeImg =fileName;
                                map.put("catnum", homeImg);
                            }
                        }
                    } else {
                        //����������ͨ���ֶ�
                        String fieldName = item.getFieldName();
                        String string = item.getString("utf-8");
                        map.put(fieldName, string);
                    }

                }
                return map;
            } catch (FileUploadBase.SizeLimitExceededException e) {
            	out.print("<script>alert('ͼƬ��С������Χ��ֻ���ϴ����4M��ͼƬ!');window.location.href='/catcatcat.jsp'</script>");
                
			}
            catch (Exception e) {
                e.printStackTrace();
                out.print("<script>alert('�����쳣!');window.location.href='/catcatcat.jsp'</script>");
            }
        }
        return null;
    }
}

