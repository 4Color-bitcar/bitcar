package service;

import java.util.List;

import dao.UsersDAO;
import vo.UsersVO;

public class UserServiceImpl implements UserService{
    private UsersDAO dao;

    
	public UserServiceImpl(UsersDAO dao) {
		this.dao = dao;
	}
	

	public UsersDAO getDao() {
		return dao;
	}


	public void setDao(UsersDAO dao) {
		this.dao = dao;
	}


	@Override
	public List<UsersVO> getAllUserInfo() {
		return dao.getUsersRecord();
	}

	@Override
	public int signUp(UsersVO user) {
		return dao.signUp(user);
	}

	@Override
	public UsersVO login(String id, String pw) {
		return dao.login(id, pw);
	}

	@Override
	public int deleteUser(String user_id) {
		return dao.deleteUser(user_id);
	}

	@Override
	public int updateUser(String pw, String id) {
		return dao.updateUser(pw,id);
	}
	
	@Override
	public boolean idCheck(String user_id) {
		return dao.idCheck(user_id);
	}

}
