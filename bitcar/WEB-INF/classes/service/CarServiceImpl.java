package service;

import java.util.List;

import dao.CarDAO;
import vo.CarVO;

public class CarServiceImpl implements CarService{
	
	CarDAO dao;

	public CarServiceImpl() {  }
	public CarServiceImpl(CarDAO dao) {
		this.dao = dao;
	}
	
	public CarDAO getDao() {
		return dao;
	}
	public void setDao(CarDAO dao) {
		this.dao = dao;
	}
	
	
	@Override
	public List<CarVO> getCarRec() {
		return dao.getCarRec();
	}

	@Override
	public List<CarVO> getHyundaiCarRec() {
		return dao.getHyundaiCarRec();
	}

	@Override
	public List<CarVO> getKiaCarRec() {
		return dao.getKiaCarRec();
	}

	@Override
	public int insertCar(CarVO vo) throws Exception {
		return dao.insertCar(vo);
	}

	@Override
	public int updateCar(CarVO vo) {
		return dao.updateCar(vo);
	}

	@Override
	public int deleteCar(String type) {
		return dao.deleteCar(type);
	}
	@Override
	public List<CarVO> searchCar(String keyword) {
		return dao.searchCar(keyword);
	}
	@Override
	public List<CarVO> getCarRec(int page) {
		return dao.getCarRec(page);
	}

}
