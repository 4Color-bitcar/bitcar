package vo;

public class ImgVO {
	private int imgNum;
	private String img_type;
	private String img_path1;
	private String img_path2;
	private String img_path3;
	
	public ImgVO() {}
	public ImgVO(int imgNum, String img_type, String img_path1, String img_path2, String img_path3) {
		this.imgNum = imgNum;
		this.img_type = img_type;
		this.img_path1 = img_path1;
		this.img_path2 = img_path2;
		this.img_path3 = img_path3;
	}
	
	
	public int getImgNum() {
		return imgNum;
	}
	public void setImgNum(int imgNum) {
		this.imgNum = imgNum;
	}
	public String getImg_type() {
		return img_type;
	}
	public void setImg_type(String img_type) {
		this.img_type = img_type;
	}
	public String getImg_path1() {
		return img_path1;
	}
	public void setImg_path1(String img_path1) {
		this.img_path1 = img_path1;
	}
	public String getImg_path2() {
		return img_path2;
	}
	public void setImg_path2(String img_path2) {
		this.img_path2 = img_path2;
	}
	public String getImg_path3() {
		return img_path3;
	}
	public void setImg_path3(String img_path3) {
		this.img_path3 = img_path3;
	}
	
	
	@Override
	public String toString() {
		return "ImgVO [imgNum=" + imgNum + ", img_type=" + img_type + ", img_path1=" + img_path1 + ", img_path2="
				+ img_path2 + ", img_path3=" + img_path3 + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + imgNum;
		result = prime * result + ((img_path1 == null) ? 0 : img_path1.hashCode());
		result = prime * result + ((img_path2 == null) ? 0 : img_path2.hashCode());
		result = prime * result + ((img_path3 == null) ? 0 : img_path3.hashCode());
		result = prime * result + ((img_type == null) ? 0 : img_type.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImgVO other = (ImgVO) obj;
		if (imgNum != other.imgNum)
			return false;
		if (img_path1 == null) {
			if (other.img_path1 != null)
				return false;
		} else if (!img_path1.equals(other.img_path1))
			return false;
		if (img_path2 == null) {
			if (other.img_path2 != null)
				return false;
		} else if (!img_path2.equals(other.img_path2))
			return false;
		if (img_path3 == null) {
			if (other.img_path3 != null)
				return false;
		} else if (!img_path3.equals(other.img_path3))
			return false;
		if (img_type == null) {
			if (other.img_type != null)
				return false;
		} else if (!img_type.equals(other.img_type))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
