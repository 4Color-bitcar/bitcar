package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import vo.UsersVO;


//모든 회원정보, 회원가입, 로그인, 회원삭제, 비번변경, 
public class UsersDAO {

	// 모든 회원을 열람 가능  
	public List<UsersVO> getUsersRecord() {

		List<UsersVO> list = new ArrayList<UsersVO>();

		String sql = "SELECT * FROM ( " + 
					"SELECT rownum row#, id, pw, name, phone, role " + 
					"FROM ( SELECT * FROM users order by id ) " + 
					") WHERE row# between ? and ? ";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setInt(2, 10);

			rs = ps.executeQuery();

			while (rs.next()) {
				UsersVO users = new UsersVO();
				users.setId(rs.getString("id"));
				users.setPw(rs.getString("pw"));
				users.setName(rs.getString("name"));
				users.setPhone(rs.getString("phone"));
				users.setRole(rs.getString("role"));
				
				list.add(users);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}

		return list;

	}// getCarRecord()

	
	// 회원가입
	public int signUp(UsersVO user) {
		String sql = "INSERT INTO users(id, pw, name, phone) VALUES(?,?,?,?) ";

		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;

		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getId());
			ps.setString(2, user.getPw());
			ps.setString(3, user.getName());
			ps.setString(4, user.getPhone());

			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, null);
		}

		return result;

	}// signUp

	// 로그인   
	public UsersVO login(String id, String pw) {						
		String sql = "SELECT id, pw, name, phone, role FROM users WHERE id = ? ";					
							
		UsersVO vo = new UsersVO();					
		Connection con = null;					
		PreparedStatement ps = null;					
		ResultSet rs = null;					
							
							
		try {					
			con = JDBCUtil.getConnection();				
			ps = con.prepareStatement(sql);				
			ps.setString(1, id);				
			rs = ps.executeQuery();				
							
			while (rs.next()) {				
				
					vo.setId(rs.getString("id"));
					vo.setPw(rs.getString("pw"));		
					vo.setName(rs.getString("name"));		
					vo.setPhone(rs.getString("phone"));		
					vo.setRole(rs.getString("role"));
				
			}			
							
		} catch (SQLException e) {					
			System.out.println(e.getMessage());				
		} catch (Exception e) {					
			e.printStackTrace();				
		} finally {
			JDBCUtil.close(con, ps, rs);
		}				
							
		return vo; 	
							
	}// login			
	
	
	//회원삭제  
	public int deleteUser(String user_id) {
		
		String sql = "DELETE FROM users WHERE id=? ";
		Connection con = null;
		PreparedStatement ps = null;
		int result =0;
		
		try {
			con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user_id);
			
			result = ps.executeUpdate();
			
		}catch( SQLException e) {
			System.out.println(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(con, ps, null);
		}
		return result;
		
	}//deleteuser
	
	//회원정보변경  (비번만 변경가능) 
    public int updateUser(String pw, String id) {
    	
    	String sql = "UPDATE users SET pw = ? WHERE id = ? ";
    	Connection con = null;
    	PreparedStatement ps = null;
    	int result = 0; 
    	
    	try {
    		con = JDBCUtil.getConnection();
    		ps = con.prepareStatement(sql);
    		
    		ps.setString(1, pw);
    		ps.setString(2, id);
    		
    		result = ps.executeUpdate();
    		
    	}catch(SQLException e) {
    		System.out.println(e.getMessage());
    	}catch(Exception e) {
    		e.printStackTrace();
    	}finally {
			JDBCUtil.close(con, ps, null);
			
		}
    	
    	return result;
    	
    }//updateUser
	
	//아이디 중복 체크 확인 하기 
    public boolean idCheck(String user_id) {
    	String sql = "SELECT id FROM users WHERE id = ? ";
    	Connection con = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	
    	try {
    		con = JDBCUtil.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user_id);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				if(rs.getString("id").equals(user_id)) {
					//아이디가 중복되었을 경우 true 
					return true; 
				}
			}
		} catch (SQLException e) {
            System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(con, ps, rs);
		}
    	
    	// 아이디가중복되지 않았을 경우 
    	return false;
    	
    }//idCheck()
    
    
    
   
	
	
	
	

}


































