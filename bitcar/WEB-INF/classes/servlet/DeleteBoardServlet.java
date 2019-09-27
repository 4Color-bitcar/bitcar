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

@WebServlet("/deleteboard.do")
public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String[] no = request.getParameterValues("no");
		
		
		BoardDAO dao = new BoardDAO();
		BoardService service =  new BoardServiceImpl(dao);
		
			
			
		try {
			for(String data : no) {
			    service.deleteBoard(Integer.parseInt(data));	
			}
			response.sendRedirect("listboard.do");
			
			
		}catch(Exception e) {
			request.setAttribute("exception", e);
			request.getRequestDispatcher("/error.jsp").forward(request, response);
			
		}
		
		
		
	
	
	}

}
