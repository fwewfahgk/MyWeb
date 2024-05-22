package niit.dao;

import java.util.ArrayList;

import niit.entity.Cat;

public interface CatDao {
	//查询用户表的所有猫的信息
	public boolean selectByCatnum(int catnum);
	public  ArrayList<Cat>  queryCatAll();
	public Cat showByCatnum(int catnum);
	public boolean idExist(int catnum);
	public boolean addByCatnum(Cat stu) ;
}
