package service;

import java.util.List;

import dao.ImgDAO;
import vo.ImgVO;

public class ImgServiceImpl implements ImgService{

	ImgDAO dao;
	
	public ImgServiceImpl() {  }
	public ImgServiceImpl(ImgDAO dao) {
		this.dao = dao;
	}
	
	

	public ImgDAO getDao() {
		return dao;
	}

	public void setDao(ImgDAO dao) {
		this.dao = dao;
	}


	@Override
	public int insertImg(ImgVO img) {
		return dao.insertImg(img);
	}

	@Override
	public int deleteImg(String img_type) {
		return dao.deleteImg(img_type);
	}

	@Override
	public List<ImgVO> getImgRec() {
		return dao.getImgRec();
	}
	@Override
	public int insertImg1(ImgVO img) {
		return dao.insertImg1(img);
	}
	@Override
	public int insertImg2(ImgVO img) {
		return dao.insertImg2(img);
	}
	@Override
	public int insertImg3(ImgVO img) {
		return dao.insertImg3(img);
	}
	

}
