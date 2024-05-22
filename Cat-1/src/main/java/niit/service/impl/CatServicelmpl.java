package niit.service.impl;

import java.util.ArrayList;

import niit.dao.CatDao;
import niit.dao.impl.CatDaoImpl;
import niit.entity.Cat;
import niit.service.CatService;

public class CatServicelmpl implements CatService{
	CatDao dao=new CatDaoImpl();
	
	
	
	@Override
	public ArrayList<Cat> queryCatAll() {
		// TODO Auto-generated method stub
		return dao.queryCatAll();
	}


	public boolean addByCatnum(Cat stu) {
		if (dao.idExist(stu.getCatnum())) {//true£ºÑ§Éú´æÔÚ
			return false;
		}else {
			return dao.addByCatnum(stu);
		}
	}
	

	@Override
	public boolean selectByCatnum(int catnum) {
		
		return dao.selectByCatnum(catnum);
	}


	@Override
	public boolean updateByCatnum(Cat stu) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
