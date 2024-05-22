package niit.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import niit.dao.CatDao;
import niit.entity.Cat;
import niit.util.DBUtil;

//dao层的具体实现类：目标就是访问底层数据库代码
public class CatDaoImpl implements CatDao{
	DBUtil util=new DBUtil();
	@Override
	public ArrayList<Cat> queryCatAll() {
		//1、先声明数据库语句
		String  sql="select * from smbms_cat";
		//2、调用通用数据库帮助类的对应的方法
		ResultSet rs=util.executeQuery(sql);
		Cat cat=null;
		ArrayList<Cat> lists=new ArrayList<Cat>();
		try {
			if(rs!=null) {//先判断结果集是否为null,不为null才可以取
					while(rs.next()) {
						//获取结果集的值存给user,再将user存给集合
						cat=new Cat();
						//需要将值挨个赋值给user
						cat.setName(rs.getString("name"));
						cat.setBreed(rs.getString("breed"));
						cat.setSex(rs.getString("sex"));
						cat.setAge(rs.getInt("age"));
						cat.setAddress(rs.getString("address"));
						cat.setCharacter(rs.getString("character"));
						cat.setCatnum(rs.getInt("catnum"));
						lists.add(cat);//将数据存给集合					
					}		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;

	}
	
	public Cat showByCatnum(int catnum) {	
		String  sql1="select * from smbms_cat where catnum=? ";//查询student表的所有信息
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
		String  sql1="insert into smbms_cat values(?,?,?,?,?,?,?)";//添加数据
		return	DBUtil.executeUpdate(sql1,stu.getCatnum(), stu.getName(),stu.getBreed(),stu.getSex(),stu.getAge(),stu.getAddress(),stu.getCharacter());
	}
}
