package service;

import java.util.List;

import dao.BoardDAO;
import vo.BoardVo;

public class BoardServiceImpl implements BoardService {
	
	BoardDAO dao;

	public BoardServiceImpl() { }
	public BoardServiceImpl(BoardDAO dao) {
		super();
		this.dao = dao;
	}
	
	
	
	public BoardDAO getDao() {
		return dao;
	}
	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public List<BoardVo> boardList() {
		return dao.getBoardRec();
	}

	@Override
	public int addBoard(BoardVo vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public int deleteBoard(int no) {
		return dao.deleteBoard(no);
	}

	@Override
	public int updateBoard(BoardVo vo) {
		return dao.updateBoard(vo);
	}

	
	
          

}
