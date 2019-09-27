package vo;

import java.sql.Date;

public class BoardVo {
	int no; 
	String b_type;
	String b_id;
	String txt;
	Date time;
	public BoardVo() {
		super();
	}
	public BoardVo(int no, String b_type, String b_id, String txt, Date time) {
		super();
		this.no = no;
		this.b_type = b_type;
		this.b_id = b_id;
		this.txt = txt;
		this.time = time;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getB_type() {
		return b_type;
	}
	public void setB_type(String b_type) {
		this.b_type = b_type;
	}
	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", b_type=" + b_type + ", b_id=" + b_id + ", txt=" + txt + ", time=" + time + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((b_id == null) ? 0 : b_id.hashCode());
		result = prime * result + ((b_type == null) ? 0 : b_type.hashCode());
		result = prime * result + no;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + ((txt == null) ? 0 : txt.hashCode());
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
		BoardVo other = (BoardVo) obj;
		if (b_id == null) {
			if (other.b_id != null)
				return false;
		} else if (!b_id.equals(other.b_id))
			return false;
		if (b_type == null) {
			if (other.b_type != null)
				return false;
		} else if (!b_type.equals(other.b_type))
			return false;
		if (no != other.no)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		if (txt == null) {
			if (other.txt != null)
				return false;
		} else if (!txt.equals(other.txt))
			return false;
		return true;
	}
	
	
	
}
