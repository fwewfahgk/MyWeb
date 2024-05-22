package niit.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import niit.dao.UserDao;
import niit.entity.User;
import niit.util.DBUtil;

//dao层的具体实现类：目标就是访问底层数据库代码
public class UserDaoImpl implements UserDao{
	DBUtil util=new DBUtil();//先创建数据库帮助类
	
	
	//根据账号来查询某个用户信息
	@Override
	public User queryUser(String userCode) {//这个方法如果返回null说明这人不存在
		//1、先声明数据库语句
		String  sql="select * from smbms_user where userCode=?";
		//2、调用通用数据库帮助类的对应的方法
		ResultSet rs=util.executeQuery(sql, userCode);
		//3、处理返回结果：接收当前用户的值
		User user=null;
		try {
			if(rs!=null&&rs.next()) {//判断结果集不为null我才可以接收到值
				user=new User();
				//需要将值挨个赋值给user
				user.setId(rs.getInt("id"));
				user.setUserCode(rs.getString("userCode"));
				user.setUserName(rs.getString("userName"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				//多出来的:年龄不用设置：因为它是根据生日自动赋值
				//user.setUserRoleName(rs.getString("userRoleName"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return user;//user要么是null  要么就有值
	}

	@Override//根据账号判断这个人是否存在
	public boolean isExits(String userCode) {//这个方法返回true说明这个人存在		
		boolean flag=false;//一开始默认是不存在
		if (queryUser(userCode)!=null) {
			flag=true;//只要有值说明存在，就改为true
		}	
		return flag;
	}
	
	
	
	
	//查询用户表的所有人的信息
	@Override
	public ArrayList<User> queryUserAll() {
		//1、先声明数据库语句
		String  sql="select * from smbms_user";
		//2、调用通用数据库帮助类的对应的方法
		ResultSet rs=util.executeQuery(sql);
		User user=null;
		ArrayList<User> lists=new ArrayList<User>();
		try {
			if(rs!=null) {//先判断结果集是否为null,不为null才可以取
					while(rs.next()) {
						//获取结果集的值存给user,再将user存给集合
						user=new User();
						//需要将值挨个赋值给user
						user.setId(rs.getInt("id"));
						user.setUserCode(rs.getString("userCode"));
						user.setUserName(rs.getString("userName"));
						user.setUserPassword(rs.getString("userPassword"));
						user.setPhone(rs.getString("phone"));
						user.setAddress(rs.getString("address"));
						lists.add(user);//将数据存给集合					
					}		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}

	@Override
	public boolean updateById(User stu) {
		// TODO Auto-generated method stub
		return false;
	}

}
