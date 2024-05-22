package niit.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import niit.dao.CatDao;
import niit.entity.Cat;
import niit.util.DBUtil;

//dao��ľ���ʵ���ࣺĿ����Ƿ��ʵײ����ݿ����
public class CatDaoImpl implements CatDao{
	DBUtil util=new DBUtil();
	@Override
	public ArrayList<Cat> queryCatAll() {
		//1�����������ݿ����
		String  sql="select * from smbms_cat";
		//2������ͨ�����ݿ������Ķ�Ӧ�ķ���
		ResultSet rs=util.executeQuery(sql);
		Cat cat=null;
		ArrayList<Cat> lists=new ArrayList<Cat>();
		try {
			if(rs!=null) {//���жϽ�����Ƿ�Ϊnull,��Ϊnull�ſ���ȡ
					while(rs.next()) {
						//��ȡ�������ֵ���user,�ٽ�user�������
						cat=new Cat();
						//��Ҫ��ֵ������ֵ��user
						cat.setName(rs.getString("name"));
						cat.setBreed(rs.getString("breed"));
						cat.setSex(rs.getString("sex"));
						cat.setAge(rs.getInt("age"));
						cat.setAddress(rs.getString("address"));
						cat.setCharacter(rs.getString("character"));
						cat.setCatnum(rs.getInt("catnum"));
						lists.add(cat);//�����ݴ������					
					}		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;

	}
	
	public Cat showByCatnum(int catnum) {	
		String  sql1="select * from smbms_cat where catnum=? ";//��ѯstudent���������Ϣ
		Cat stu=null;
		ResultSet rSet=DBUtil.executeQuery(sql1, catnum);
		try {
			if (rSet.next()) {//
					stu=new Cat();
					stu.setCatnum(rSet.getInt(1));
					stu.setName(rSet.getString(2));
					stu.setBreed(rSet.getString(3));
					stu.setSex(rSet.getString(4));
					stu.setAge(rSet.getInt(5));
					stu.setAddress(rSet.getString(6));
					stu.setCharacter(rSet.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return stu;			
	}
	
	
	
	public boolean idExist(int catnum) {
		Cat stu=showByCatnum(catnum);
		if (stu==null) {
			return false;
		} else {
			return true;
		}
	}
	
	
	@Override
	public boolean selectByCatnum(int catnum) {
		String sql="delete from smbms_cat where catnum=?";
		return DBUtil.executeUpdate(sql, catnum);
	}
	public boolean addByCatnum(Cat stu) {
		//JDBCDao();
		String  sql1="insert into smbms_cat values(?,?,?,?,?,?,?)";//�������
		return	DBUtil.executeUpdate(sql1,stu.getCatnum(), stu.getName(),stu.getBreed(),stu.getSex(),stu.getAge(),stu.getAddress(),stu.getCharacter());
	}
}
