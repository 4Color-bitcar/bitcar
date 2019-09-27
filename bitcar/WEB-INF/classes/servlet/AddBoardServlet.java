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

@WebServlet("/addboard.do")
public class AddBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/addboard.do 요청 처리");
		
		System.out.println(request.getParameter("b_type"));
		System.out.println(request.getParameter("b_id"));
		System.out.println(request.getParameter("txt"));
		
		BoardDAO dao = new BoardDAO();
		BoardService service = new BoardServiceImpl(dao);
		
		BoardVo vo = new BoardVo();
		vo.setB_type(request.getParameter("b_type"));
		vo.setB_id(request.getParameter("b_id"));
		vo.setTxt(request.getParameter("txt"));
		
		try { 
			service.addBoard(vo);
			request.getRequestDispatcher("/listboard.do").forward(request, response);
			
		} catch (Exception e) {
			request.setAttribute("exception", new Exception("값이 올바르지 않습니다."));
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
			
		}
		
		
		
	
	
	
	}

}
