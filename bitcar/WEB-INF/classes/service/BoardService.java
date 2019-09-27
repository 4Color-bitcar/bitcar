package service;

import java.util.List;

import vo.BoardVo;

public interface BoardService {
	
	public List<BoardVo> boardList();
	public int addBoard(BoardVo vo);
	public int deleteBoard(int no);
	public int  updateBoard(BoardVo vo);
	
}
