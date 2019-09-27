package service;

import java.util.List;

import vo.ImgVO;

public interface ImgService {
	int insertImg(ImgVO img);
	int deleteImg(String car_type);  // 키값인 차종 
	public List<ImgVO> getImgRec();
	public int insertImg1(ImgVO img);
	public int insertImg2(ImgVO img);
	public int insertImg3(ImgVO img);

}
