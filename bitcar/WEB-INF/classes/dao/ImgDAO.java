package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.ImgVO;

public class ImgDAO {
	
	//이미지 등록 및 삭제 기능 
	public int insertImg(ImgVO img) {
		
		String sql = "INSERT INTO img(no, i_type, i_img_1, i_img_2, i_img_3) VALUES(seq_i.NEXTVAL, ?, ?, ?, ?) ";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0; 
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, img.getImg_type());
			ps.setString(2, img.getImg_path1());
			ps.setString(3, img.getImg_path2());
			ps.setString(4, img.getImg_path3());
			
			result = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return result;
		
	}//insertImg()
	
	public int insertImg1(ImgVO img) {
		
		String sql = "INSERT INTO img(no, i_type, i_img_1) VALUES(seq_i.NEXTVAL, ?, ?) ";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0; 
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, img.getImg_type());
			ps.setString(2, img.getImg_path1());
			
			result = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return result;
		
	}//insertImg()
	
	public int insertImg2(ImgVO img) {
		
		String sql = "UPDATE img SET i_img_2 = ? where i_type = ? ";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0; 
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, img.getImg_path2());
			ps.setString(2, img.getImg_type());
			
			result = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return result;
		
	}//insertImg()
	
	public int insertImg3(ImgVO img) {
		
		String sql = "UPDATE img SET i_img_3 = ? where i_type = ? ";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0; 
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, img.getImg_path3());
			ps.setString(2, img.getImg_type());
			
			result = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return result;
		
	}//insertImg()

	
	public int deleteImg(String img_type) {
		
		String sql = "delete from img i " + 
				"where i.i_type = ( " + 
				"select c.type from car c " + 
				"where i.i_type = c.type and c.type = ? " + 
				" ) " ;
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, img_type);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
            System.out.println(e.getMessage());
		} finally {
			JDBCUtil.close(con, ps, null);
			
		}
		
		return result;
		
	}//deleteImg()
	
	
	public List<ImgVO> getImgRec() {
		
		String sql = "select * from img order by no";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<ImgVO> list = new ArrayList<ImgVO>();
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				ImgVO vo = new ImgVO();
				vo.setImgNum(rs.getInt("no"));
				vo.setImg_type(rs.getString("i_type"));
				vo.setImg_path1(rs.getString("i_img_1"));
				vo.setImg_path2(rs.getString("i_img_2"));
				vo.setImg_path3(rs.getString("i_img_3"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return list;
		
	}
	
	
	
	
}



























