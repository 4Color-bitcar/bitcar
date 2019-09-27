package service;

import java.util.List;

import dao.DetailDAO;
import vo.DetailVO;

public class DetailServiceImpl implements DetailService{
	
	DetailDAO dao;
	
	public DetailServiceImpl() { }
	public DetailServiceImpl(DetailDAO dao) {
		this.dao = dao;
	}
	
	public DetailDAO getDao() {
		return dao;
	}
	public void setDao(DetailDAO dao) {
		this.dao = dao;
	}
	
	
	@Override
	public DetailVO detailCar(String type) {
		return dao.detailCar(type);
	}
	
	@Override
	public List<DetailVO> detailCarRec() {
		return dao.detailCarRec();
	}

}
