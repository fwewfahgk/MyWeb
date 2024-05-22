package niit.service;

import java.util.ArrayList;

import niit.entity.User;

//业务逻辑层接口：被serviceimpl实现
public interface UserService {

	//这个根据用户名和密码判断这个人是否存在
	public  User queryUser(String userCode,String pwd);
	//查询所有用户信息
	public boolean updateById(User stu) ;
	public boolean updateByuserCode(User stu) ;
	public ArrayList<User> queryUserAll();

}
