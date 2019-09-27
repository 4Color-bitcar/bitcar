package service;

import java.util.List;

import vo.UsersVO;

public interface UserService {
	
	List<UsersVO> getAllUserInfo();
	int signUp(UsersVO user);
	UsersVO login(String id, String pw);
	int deleteUser(String user_id);
	int updateUser(String pw, String id);
	boolean idCheck(String user_id);
	

}
