package niit.service;

import java.util.ArrayList;

import niit.entity.User;

//ҵ���߼���ӿڣ���serviceimplʵ��
public interface UserService {

	//��������û����������ж�������Ƿ����
	public  User queryUser(String userCode,String pwd);
	//��ѯ�����û���Ϣ
	public boolean updateById(User stu) ;
	public boolean updateByuserCode(User stu) ;
	public ArrayList<User> queryUserAll();

}
