package niit.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import niit.dao.UserDao;
import niit.entity.User;
import niit.util.DBUtil;

//dao��ľ���ʵ���ࣺĿ����Ƿ��ʵײ����ݿ����
public class UserDaoImpl implements UserDao{
	DBUtil util=new DBUtil();//�ȴ������ݿ������
	
	
	//�����˺�����ѯĳ���û���Ϣ
	@Override
	public User queryUser(String userCode) {//��������������null˵�����˲�����
		//1�����������ݿ����
		String  sql="select * from smbms_user where userCode=?";
		//2������ͨ�����ݿ������Ķ�Ӧ�ķ���
		ResultSet rs=util.executeQuery(sql, userCode);
		//3�������ؽ�������յ�ǰ�û���ֵ
		User user=null;
		try {
			if(rs!=null&&rs.next()) {//�жϽ������Ϊnull�Ҳſ��Խ��յ�ֵ
				user=new User();
				//��Ҫ��ֵ������ֵ��user
				user.setId(rs.getInt("id"));
				user.setUserCode(rs.getString("userCode"));
				user.setUserName(rs.getString("userName"));
				user.setUserPassword(rs.getString("userPassword"));
				user.setPhone(rs.getString("phone"));
				user.setAddress(rs.getString("address"));
				//�������:���䲻�����ã���Ϊ���Ǹ��������Զ���ֵ
				//user.setUserRoleName(rs.getString("userRoleName"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return user;//userҪô��null  Ҫô����ֵ
	}

	@Override//�����˺��ж�������Ƿ����
	public boolean isExits(String userCode) {//�����������true˵������˴���		
		boolean flag=false;//һ��ʼĬ���ǲ�����
		if (queryUser(userCode)!=null) {
			flag=true;//ֻҪ��ֵ˵�����ڣ��͸�Ϊtrue
		}	
		return flag;
	}
	
	
	
	
	//��ѯ�û���������˵���Ϣ
	@Override
	public ArrayList<User> queryUserAll() {
		//1�����������ݿ����
		String  sql="select * from smbms_user";
		//2������ͨ�����ݿ������Ķ�Ӧ�ķ���
		ResultSet rs=util.executeQuery(sql);
		User user=null;
		ArrayList<User> lists=new ArrayList<User>();
		try {
			if(rs!=null) {//���жϽ�����Ƿ�Ϊnull,��Ϊnull�ſ���ȡ
					while(rs.next()) {
						//��ȡ�������ֵ���user,�ٽ�user�������
						user=new User();
						//��Ҫ��ֵ������ֵ��user
						user.setId(rs.getInt("id"));
						user.setUserCode(rs.getString("userCode"));
						user.setUserName(rs.getString("userName"));
						user.setUserPassword(rs.getString("userPassword"));
						user.setPhone(rs.getString("phone"));
						user.setAddress(rs.getString("address"));
						lists.add(user);//�����ݴ������					
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
