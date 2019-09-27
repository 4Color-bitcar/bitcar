package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.DetailVO;

public class DetailDAO {
	
	public DetailVO detailCar(String type) {
		
		//이미지 테이블과 조인해서 이미지들 다 불러오는 sql로 수정해야함.
		String sql = "select brand, type , year, history, km, price ,img, i_img_1, i_img_2, i_img_3 " +
					"from car c, img i " +
					"where type = i_type and i_type =? ";
		
		DetailVO vo = new DetailVO();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, type);
			
			System.out.println(type);
			rs = ps.executeQuery();
			
			System.out.println(rs.toString());
			while (rs.next()) {
				vo.setBrand(rs.getString("brand"));
				vo.setType(rs.getString("type"));
				vo.setYear(rs.getString("year"));
				vo.setHistory(rs.getString("history"));
				vo.setKm(rs.getString("km"));
				vo.setPrice(rs.getString("price"));
				vo.setImg(rs.getString("img"));
				vo.setSubimg1(rs.getString("i_img_1"));
				vo.setSubimg2(rs.getString("i_img_2"));
				vo.setSubimg3(rs.getString("i_img_3"));
				
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		System.out.println("Dao : " + vo);
		return vo;
		
	}
	
	public List<DetailVO> detailCarRec() {
		
		//이미지 테이블과 조인해서 이미지들 다 불러오는 sql로 수정해야함.
		String sql = "select brand, type , year, history, km, price ,img, i_img_1, i_img_2, i_img_3 " +
				"from car c, img i " +
				"where type = i_type";
		
		List<DetailVO> list = new ArrayList<DetailVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				DetailVO vo = new DetailVO();
				vo.setBrand(rs.getString("brand"));
				vo.setType(rs.getString("type"));
				vo.setYear(rs.getString("year"));
				vo.setHistory(rs.getString("history"));
				vo.setKm(rs.getString("km"));
				vo.setPrice(rs.getString("price"));
				vo.setImg(rs.getString("img"));
				vo.setSubimg1(rs.getString("i_img_1"));
				vo.setSubimg2(rs.getString("i_img_2"));
				vo.setSubimg3(rs.getString("i_img_3"));
				
				list.add(vo);
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
		
	}

}
