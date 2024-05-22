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
			//new一个 map用来保存图片名和普通表单的值
			HashMap<String,String> map=new HashMap<String, String>();
			DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setHeaderEncoding("UTF-8");
            //设置上传文件大小：单位 byte
            upload.setSizeMax(1024*1024*4);
            try {
                // 解析form表单中所有文件
                List<FileItem> items = upload.parseRequest(request);
                for (FileItem item : items) {
                    // 普通表单字段true, 文件表单字段false
                    if (!item.isFormField()) {
                        //文件名
                        String fileName = item.getName();
                        if (fileName != null || !"".equals(fileName)) {
                            //String s = fileName.substring(fileName.lastIndexOf('.'));
                            String s1 = fileName.substring(fileName.lastIndexOf('.')+1);
                           boolean a=s1.equals("jpg")||s1.equals("jpeg")||s1.equals("png");
                            if (!a) {
                                // 跳转路径 
                                out.print("<script>alert('文件格式不正确！只能上传jpg、gif、jpeg、png图片');window.location.href='/catcatcat.jsp'</script>");
                            } else {
                                // 处理文件同名的问题，在文件名前添加UUID
                               File saveFile = new File(uploadFilePath,fileName);
                                //上传
                                item.write(saveFile);
                                // 文件名
                                String homeImg =fileName;
                                map.put("catnum", homeImg);
                            }
                        }
                    } else {
                        //用来保存普通的字段
                        String fieldName = item.getFieldName();
                        String string = item.getString("utf-8");
                        map.put(fieldName, string);
                    }

                }
                return map;
            } catch (FileUploadBase.SizeLimitExceededException e) {
            	out.print("<script>alert('图片大小超出范围，只能上传最多4M的图片!');window.location.href='/catcatcat.jsp'</script>");
                
			}
            catch (Exception e) {
                e.printStackTrace();
                out.print("<script>alert('其他异常!');window.location.href='/catcatcat.jsp'</script>");
            }
        }
        return null;
    }
}

