package vo;

public class DetailVO {
	
	String brand;	//varchar2(10),
	String type;	//varchar2(20) primary key not null,
	String year;	//varchar2(50),
	String history;	//varchar2(1),
	String km;		//varchar2(10),
	String price;	//varchar2(50),
	String img;		//varchar2(50)
	String subimg1;		//varchar2(50)
	String subimg2;		//varchar2(50)
	String subimg3;		//varchar2(50)
	
	public DetailVO() {   }
	public DetailVO(String brand, String type, String year, String history, String km, String price, String img,
			String subimg1, String subimg2, String subimg3) {
		super();
		this.brand = brand;
		this.type = type;
		this.year = year;
		this.history = history;
		this.km = km;
		this.price = price;
		this.img = img;
		this.subimg1 = subimg1;
		this.subimg2 = subimg2;
		this.subimg3 = subimg3;
	}
	
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getKm() {
		return km;
	}
	public void setKm(String km) {
		this.km = km;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getSubimg1() {
		return subimg1;
	}
	public void setSubimg1(String subimg1) {
		this.subimg1 = subimg1;
	}
	public String getSubimg2() {
		return subimg2;
	}
	public void setSubimg2(String subimg2) {
		this.subimg2 = subimg2;
	}
	public String getSubimg3() {
		return subimg3;
	}
	public void setSubimg3(String subimg3) {
		this.subimg3 = subimg3;
	}
	
	
	@Override
	public String toString() {
		return "DetailVO [brand=" + brand + ", type=" + type + ", year=" + year + ", history=" + history + ", km=" + km
				+ ", price=" + price + ", img=" + img + ", subimg1=" + subimg1 + ", subimg2=" + subimg2 + ", subimg3="
				+ subimg3 + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((history == null) ? 0 : history.hashCode());
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((km == null) ? 0 : km.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((subimg1 == null) ? 0 : subimg1.hashCode());
		result = prime * result + ((subimg2 == null) ? 0 : subimg2.hashCode());
		result = prime * result + ((subimg3 == null) ? 0 : subimg3.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
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
		DetailVO other = (DetailVO) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (history == null) {
			if (other.history != null)
				return false;
		} else if (!history.equals(other.history))
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (km == null) {
			if (other.km != null)
				return false;
		} else if (!km.equals(other.km))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (subimg1 == null) {
			if (other.subimg1 != null)
				return false;
		} else if (!subimg1.equals(other.subimg1))
			return false;
		if (subimg2 == null) {
			if (other.subimg2 != null)
				return false;
		} else if (!subimg2.equals(other.subimg2))
			return false;
		if (subimg3 == null) {
			if (other.subimg3 != null)
				return false;
		} else if (!subimg3.equals(other.subimg3))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
