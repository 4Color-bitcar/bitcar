package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.CarVO;

public class CarDAO {
	
	/*
	INSERT INTO car				
	VALUES(seq_c.NEXTVAL, 'kia', 'seltos', '2012', '1','50000','24000000','null');
	
	INSERT INTO car(no, brand, type, year, history, km, price, img) 				
	VALUES(seq_c.NEXTVAL, 'kia', 'test', '2012', '1','7777','777777','null');
	
	INSERT INTO car(no, brand, type, year, history, km, price, img) 				
	VALUES(seq_c.NEXTVAL, ?, ?, ?, ?, ?, ?, ?);
	
	
	 select * from ( 
				select rownum row#, no, brand, type, year,  history, km, price, img 
				from (select * from car order by no) 
			) where row# between ? and ? 

	 select * from ( 
				select rownum row#, no, brand, type, year,  history, km, price, img 
				from (select * from car where brand='hyu' order by no) 
			) where row# between ? and ? 
			
	*/			
	
	
	
	public List<CarVO> searchCar(String keyword) {
		
		String sql = "select * from ( " + 
				"select rownum row#, no, brand, type, year,  history, km, price, img " + 
				"from (select * from car where upper(type) like '%'||upper(?)||'%' order by no) " + 
				") where row# between ? and ? ";
		
		List<CarVO> list = new ArrayList<CarVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, keyword);
			ps.setInt(2, 1);
			ps.setInt(3, 10);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				CarVO vo = new CarVO();
				vo.setNo(rs.getInt("no"));
				vo.setBrand(rs.getString("brand"));
				vo.setType(rs.getString("type"));
				vo.setYear(rs.getString("year"));
				vo.setHistory(rs.getString("history"));
				vo.setKm(rs.getString("km"));
				vo.setPrice(rs.getString("price"));
				vo.setImg(rs.getString("img"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}
	
	
	public List<CarVO> getCarRec(int page) {

		int startNum = (page - 1) * 10 + 1;
		int endNum = page * 10;

		String sql = "select * from " + "(select * from(select ROWNUM as row_num, car.* "
				+ "    from car) where row_num >= ?) where row_num <= ? ";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<CarVO> list = new ArrayList<CarVO>();

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);

			ps.setInt(1, startNum);
			ps.setInt(2, endNum);

			rs = ps.executeQuery();
			while (rs.next()) {
				CarVO vo = new CarVO();
				vo.setNo(rs.getInt("no"));
				vo.setBrand(rs.getString("brand"));
				vo.setType(rs.getString("type"));
				vo.setYear(rs.getString("year"));
				vo.setHistory(rs.getString("history"));
				vo.setKm(rs.getString("km"));
				vo.setPrice(rs.getString("price"));
				vo.setImg(rs.getString("img"));

				list.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}

		return list;

	}//getCarRec()
	
	public List<CarVO> getCarRec() {
		
		String sql = "select * from ( " + 
				"select rownum row#, no, brand, type, year, history, km, price, img " + 
				"from (select * from car order by no) " + 
				") where row# between ? and ? ";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<CarVO> list = new ArrayList<CarVO>();
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, 1);
			ps.setInt(2, 10);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				CarVO vo = new CarVO();
				vo.setNo(rs.getInt("no"));
				vo.setBrand(rs.getString("brand"));
				vo.setType(rs.getString("type"));
				vo.setYear(rs.getString("year"));
				vo.setHistory(rs.getString("history"));
				vo.setKm(rs.getString("km"));
				vo.setPrice(rs.getString("price"));
				vo.setImg(rs.getString("img"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return list;
		
	}
	
	
	public List<CarVO> getHyundaiCarRec() {
		
		String sql = "select * from ( " + 
				"select rownum row#, no, brand, type, year,  history, km, price, img " + 
				"from (select * from car where brand='hyundai' order by no) " + 
				") where row# between ? and ? ";
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<CarVO> list = new ArrayList<CarVO>();
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, 1);
			ps.setInt(2, 10);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				CarVO vo = new CarVO();
				vo.setNo(rs.getInt("no"));
				vo.setBrand(rs.getString("brand"));
				vo.setType(rs.getString("type"));
				vo.setYear(rs.getString("year"));
				vo.setHistory(rs.getString("history"));
				vo.setKm(rs.getString("km"));
				vo.setPrice(rs.getString("price"));
				vo.setImg(rs.getString("img"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return list;
		
	}
	
	
	public List<CarVO> getKiaCarRec() {
		
		String sql = "select * from ( " + 
				"select rownum row#, no, brand, type, year,  history, km, price, img " + 
				"from (select * from car where brand='kia' order by no) " + 
				") where row# between ? and ? ";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<CarVO> list = new ArrayList<CarVO>();
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, 1);
			ps.setInt(2, 10);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				CarVO vo = new CarVO();
				vo.setNo(rs.getInt("no"));
				vo.setBrand(rs.getString("brand"));
				vo.setType(rs.getString("type"));
				vo.setYear(rs.getString("year"));
				vo.setHistory(rs.getString("history"));
				vo.setKm(rs.getString("km"));
				vo.setPrice(rs.getString("price"));
				vo.setImg(rs.getString("img"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return list;
		
	}
	
	
	public int insertCar(CarVO vo) throws Exception {
		
		String sql = 
				"INSERT INTO car(no, brand, type, year, history, km, price, img) " + 
						"VALUES(seq_c.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vo.getBrand());
			ps.setString(2, vo.getType());
			ps.setString(3, vo.getYear());
			ps.setString(4, vo.getHistory());
			ps.setString(5, vo.getKm());
			ps.setString(6, vo.getPrice());
			ps.setString(7, vo.getImg());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		
		return result;
	}
	
	
	public int updateCar(CarVO vo){
		String sql = "update car set price=? where type=?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, vo.getPrice());
			ps.setString(2, vo.getType());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}
	
	
	
	public int deleteCar(String type) {
		
		String sql = "delete from car where type=?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, type);
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
		
	}
	
}
