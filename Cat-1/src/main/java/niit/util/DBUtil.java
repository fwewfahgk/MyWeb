package niit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//DButil:ͨ�õ����ݿ�����ࣨ��dao����룩
public class DBUtil {
	/*
	 * ����Ȩ�����η�
	 * 	public:�����ģ��κ�λ�ö����Է���
	 *  protected���ܱ����ģ�ͬ���ڿ��Է��ʣ���ͬ����ֻ���������
	 *  Ĭ�ϣ�ͬ��������ſ��Է���
	 *  private˽�еģ�ֻ�ܵ�ǰ���ڷ���
	 */
	public static Connection conn1=null;
	//��̬������ֻ��ֱ�ӵ��þ�̬��Ա  �������ط���̬��Ա����ֱ��ͨ����������
	public static Connection getConnection() {//��ȡ�����ݿ�����
		//4.1 ��������  Class.forName("����·��");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//4.2 ��ȡ���ӣ�Connection conn=DriverManager.getConnection("���ݿ��ַ","���ݿ��û���","���ݿ�����");
			String url="jdbc:mysql://localhost/smbms?useUnicode=true&characterEncoding=UTF-8";
			String  username="root";
			String password="justice";
			conn1=DriverManager.getConnection(url, username,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn1;
	}
	//�ع����������������е���ɾ�� Object ... objects:��̬������0-n�������Ե�������ʹ��
	public static boolean executeUpdate(String sql,Object ... objects){
		PreparedStatement pre=null;
		int count=0;
		try {
			//pre = conn1.prepareStatement(sql);
			pre =DBUtil.getConnection().prepareStatement(sql);
			//��sql�����ÿ�����Ÿ�ֵ
			for(int i=0;i<objects.length;i++) {
				pre.setObject(i+1, objects[i]);
				
			}
			count=pre.executeUpdate();
			if (count>0) {
				return true;//һ������return,�����ͻ������������벻��ִ��
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
	}
	//�ع����������������еĲ�ѯ Object ... objects:��̬������0-n�������Ե�������ʹ��
	public static  ResultSet  executeQuery(String sql,Object ... objects) {	
		PreparedStatement pre=null;
		ResultSet set=null;
		try {
			pre =DBUtil.getConnection().prepareStatement(sql);
			//��sql�����ÿ�����Ÿ�ֵ
			for(int i=0;i<objects.length;i++) {
				pre.setObject(i+1, objects[i]);
				
			}
			
			set=pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return set;
		
	}
}
