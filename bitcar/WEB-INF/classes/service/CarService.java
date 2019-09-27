package service;

import java.util.List;

import vo.CarVO;

public interface CarService {
	
	public List<CarVO> getCarRec();
	public List<CarVO> getHyundaiCarRec();
	public List<CarVO> getKiaCarRec();
	public int insertCar(CarVO vo) throws Exception;
	public int updateCar(CarVO vo);
	public int deleteCar(String type);
	public List<CarVO> searchCar(String keyword);
	public List<CarVO> getCarRec(int page);

}
