package niit.dao;

import java.util.ArrayList;

import niit.entity.User;

//�û�dao��ӿڣ���daoʵ����ʵ��
public interface UserDao {
	//�����˺�����ѯĳ���û���Ϣ
	public  User queryUser(String  userCode);//�ӿ���������ֻ��д���󷽷���ֻ�з����������֣�û�з�����
	
	//�����˺��ж�������Ƿ����
	public boolean isExits(String userCode);
	
	public boolean updateById(User stu);
	//��ѯ�û���������˵���Ϣ
	public  ArrayList<User>  queryUserAll();

	
	
}
