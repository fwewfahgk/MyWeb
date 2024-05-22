package niit.dao;

import java.util.ArrayList;

import niit.entity.User;

//用户dao层接口：被dao实现类实现
public interface UserDao {
	//根据账号来查询某个用户信息
	public  User queryUser(String  userCode);//接口里面我们只能写抽象方法：只有方法声明部分，没有方法体
	
	//根据账号判断这个人是否存在
	public boolean isExits(String userCode);
	
	public boolean updateById(User stu);
	//查询用户表的所有人的信息
	public  ArrayList<User>  queryUserAll();

	
	
}
