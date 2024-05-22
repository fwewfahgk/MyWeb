package niit.service;

import java.util.ArrayList;

import niit.entity.Cat;
public interface CatService {
	//查询所有猫信息
	public ArrayList<Cat> queryCatAll();
	public boolean updateByCatnum(Cat stu) ;
	public boolean addByCatnum(Cat stu) ;
	public boolean selectByCatnum(int catnum);
}
