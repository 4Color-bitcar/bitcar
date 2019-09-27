package service;

import java.util.List;

import vo.DetailVO;

public interface DetailService {
	
	public DetailVO detailCar(String type);
	public List<DetailVO> detailCarRec();

}
