package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDAO;
import service.CarService;
import service.CarServiceImpl;
import vo.CarVO;

@WebServlet("/searchCar.do")
public class SearchCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		
		String keyword = request.getParameter("keyword");
		
		CarDAO dao = new CarDAO();
		CarService service = new CarServiceImpl(dao);
		List<CarVO> list = service.searchCar(keyword);
		
		System.out.println(list);
		
		if (list.isEmpty()) { 
			String view = "/search_null.jsp";
			getServletContext().getRequestDispatcher(view).forward(request, response);
			
		} else {
			request.setAttribute("searchlist", list);
			String view = "/search.jsp";
			getServletContext().getRequestDispatcher(view).forward(request, response);
		}
		
		
		
	}

}
