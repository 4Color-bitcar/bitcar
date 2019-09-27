package servlet;


import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import service.BoardService;
import service.BoardServiceImpl;
import vo.BoardVo;

@WebServlet("/listboard.do")
public class ListBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/listboard.do 요청");
		
		BoardDAO dao = new BoardDAO();
		
		BoardService service = new BoardServiceImpl(dao);
		
		
		List<BoardVo> list = service.boardList();
		
		request.setAttribute("boardlist", list);
		
		String view = "/boardList.jsp";
		
		getServletContext().getRequestDispatcher(view).forward(request, response);
	
	
	}

}
