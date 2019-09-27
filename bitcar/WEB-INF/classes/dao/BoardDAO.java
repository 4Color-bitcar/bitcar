package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.BoardVo;

public class BoardDAO {
	
	public List<BoardVo> getBoardRec() {
		
		List<BoardVo> list = new ArrayList<BoardVo>();
		
		String sql = "select * from ( "
				+ "select rownum row#, no, b_type, b_id, txt, time "
				+ "from (select * from board order by no) "
				+ ") where row# between ? and ? ";
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, 1);
			ps.setInt(2, 50);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVo vo=new BoardVo();
				vo.setNo(rs.getInt("no"));
				vo.setB_type(rs.getString("b_type"));
				vo.setB_id(rs.getString("b_id"));
				vo.setTxt(rs.getString("txt"));
				vo.setTime(rs.getDate("time"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, rs);
		}
		return list;
	}
	
	
	public int insertBoard(BoardVo vo) {
		String sql = "insert into board(no,b_type,b_id,txt,time) "
				     + "values(seq_b.NEXTVAL, ?, ?, ?, default)";
		
		    Connection con = null;
		    PreparedStatement ps = null;
		    int result = 0;
		    
		    try {
		    	con = JDBCUtil.getConnection();
		    	ps = con.prepareStatement(sql);
		    	
		    	ps.setString(1, vo.getB_type());
		    	ps.setString(2, vo.getB_id());
		    	ps.setString(3, vo.getTxt());
		    	
		    	result = ps.executeUpdate();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}finally {
				JDBCUtil.close(con, ps, null);
			}
		    return result;
		    
		    
	}
	
	public int deleteBoard(int no) {
		
		String sql = "delete from board where no=?";
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			ps.setInt(1, no);
			
			result=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
		
	}
	
	public int updateBoard(BoardVo vo) {
		String sql = "update board set txt=?, time=? where no=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con=JDBCUtil.getConnection();
			ps=con.prepareStatement(sql);
			
			
			ps.setString(1, vo.getTxt());
			ps.setDate(2, vo.getTime());
			ps.setInt(3, vo.getNo());
			
			
			result=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
	}

}
