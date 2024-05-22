package niit.service.impl;

import java.util.ArrayList;

import niit.dao.UserDao;
import niit.dao.impl.UserDaoImpl;
import niit.entity.User;
import niit.service.UserService;
import niit.util.DBUtil;

//ҵ���߼��㣺����ʵ����:��Ҫ�����ǵ���dao  ��Ҫȥʵ��service�ӿ�
public class UserServiceImpl  implements UserService{
	UserDao dao=new UserDaoImpl();//��߽ӿڣ��ұ�ʵ����
	@Override
	public User queryUser(String userCode, String pwd) {//��������������null˵������˲����ں����û�����������
		//�Ȳ����������Ƿ���ڣ��������ٱȽ�����Բ��ԣ������ǾͿ���ʵ�ֵ�¼����
		User user=dao.queryUser(userCode);
		if (user!=null) {
			if (pwd.equals(user.getUserPassword())) {
				return user;
			}
		}
		return null;
	}
	
	
	//����ID�޸�ѧ����Ϣ
		public boolean updateById(User stu) {
			//JDBCDao();
			String  sql1="update smbms_user set userName=?,userPassword=? where id=?";//�������
			return DBUtil.executeUpdate(sql1, stu.getUserName(),stu.getUserPassword(),stu.getId());	
		}
	
	
	
	//��ѯ�����û���Ϣ
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
