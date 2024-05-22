package niit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//DButil:通用的数据库帮助类（简化dao层代码）
public class DBUtil {
	/*
	 * 访问权限修饰符
	 * 	public:公共的：任何位置都可以访问
	 *  protected：受保护的：同包内可以访问，不同包内只有子类可以
	 *  默认：同包内子类才可以访问
	 *  private私有的：只能当前类内访问
	 */
	public static Connection conn1=null;
	//静态方法：只能直接调用静态成员  在其他地方静态成员可以直接通过类名访问
	public static Connection getConnection() {//获取到数据库连接
		//4.1 加载驱动  Class.forName("驱动路径");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//4.2 获取连接：Connection conn=DriverManager.getConnection("数据库地址","数据库用户名","数据库密码");
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
	//重构方法：适用于所有的增删改 Object ... objects:动态参数：0-n个：可以当做数组使用
	public static boolean executeUpdate(String sql,Object ... objects){
		PreparedStatement pre=null;
		int count=0;
		try {
			//pre = conn1.prepareStatement(sql);
			pre =DBUtil.getConnection().prepareStatement(sql);
			//给sql里面的每个？号赋值
			for(int i=0;i<objects.length;i++) {
				pre.setObject(i+1, objects[i]);
				
			}
			count=pre.executeUpdate();
			if (count>0) {
				return true;//一旦遇到return,方法就会结束，后面代码不再执行
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
	}
	//重构方法：适用于所有的查询 Object ... objects:动态参数：0-n个：可以当做数组使用
	public static  ResultSet  executeQuery(String sql,Object ... objects) {	
		PreparedStatement pre=null;
		ResultSet set=null;
		try {
			pre =DBUtil.getConnection().prepareStatement(sql);
			//给sql里面的每个？号赋值
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
