package niit.service.impl;

import java.util.ArrayList;

import niit.dao.UserDao;
import niit.dao.impl.UserDaoImpl;
import niit.entity.User;
import niit.service.UserService;
import niit.util.DBUtil;

//业务逻辑层：具体实现类:主要代码是调用dao  需要去实现service接口
public class UserServiceImpl  implements UserService{
	UserDao dao=new UserDaoImpl();//左边接口，右边实现类
	@Override
	public User queryUser(String userCode, String pwd) {//这个方法如果返回null说明这个人不存在后面用户名密码有误
		//先查出来这个人是否存在，存在了再比较密码对不对，对我们就可以实现登录功能
		User user=dao.queryUser(userCode);
		if (user!=null) {
			if (pwd.equals(user.getUserPassword())) {
				return user;
			}
		}
		return null;
	}
	
	
	//根据ID修改学生信息
		public boolean updateById(User stu) {
			//JDBCDao();
			String  sql1="update smbms_user set userName=?,userPassword=? where id=?";//添加数据
			return DBUtil.executeUpdate(sql1, stu.getUserName(),stu.getUserPassword(),stu.getId());	
		}
	
	
	
	//查询所有用户信息
	@Override
	public ArrayList<User> queryUserAll() {
		// TODO Auto-generated method stub
		return dao.queryUserAll();
	}
	@Override
	public boolean updateByuserCode(User stu) {
		// TODO Auto-generated method stub
		return false;
	}

}
