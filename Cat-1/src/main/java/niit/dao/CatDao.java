package niit.dao;

import java.util.ArrayList;

import niit.entity.Cat;

public interface CatDao {
	//��ѯ�û��������è����Ϣ
	public boolean selectByCatnum(int catnum);
	public  ArrayList<Cat>  queryCatAll();
	public Cat showByCatnum(int catnum);
	public boolean idExist(int catnum);
	public boolean addByCatnum(Cat stu) ;
}
