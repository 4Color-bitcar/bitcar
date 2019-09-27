package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DetailDAO;
import service.DetailService;
import service.DetailServiceImpl;
import vo.DetailVO;

@WebServlet("/detailCar.do")
public class DetailCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		
		System.out.println("/detailCar.do 요청 처리");
		
		String type = request.getParameter("type");
		
		
		DetailDAO dao = new DetailDAO();
		DetailService service = new DetailServiceImpl(dao);
		DetailVO vo = service.detailCar(type);
		
		System.out.println(vo);
		
		if (vo.getSubimg2()==null) {
			String view = "/comingsoon.jsp";
			getServletContext().getRequestDispatcher(view).forward(request, response);
		}else {
			request.setAttribute("datailcar", vo);
			String view = "/detail.jsp";
			getServletContext().getRequestDispatcher(view).forward(request, response);
		}
	}

	

}
