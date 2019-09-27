package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import service.BoardService;
import service.BoardServiceImpl;
import vo.BoardVo;

@WebServlet("/updateboard")
public class UpdateBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
	     
		
		BoardDAO dao = new BoardDAO();
		BoardService service = new BoardServiceImpl(dao);
		
		BoardVo vo = new BoardVo();
		vo.setTxt(request.getParameter("txt"));
		//vo.setTime(request.getParameter("date"));
		
		
		         
			try {
			
			service.updateBoard(vo);
			response.sendRedirect("listboard.do");
			
			
		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			
			
		}
	
		
	
	
	
	}

	
	
	
	
	

}
