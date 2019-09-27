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
import vo.Paging;

@WebServlet("/listCar.do")
public class ListCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		
		System.out.println("/listCar.do 요청 처리");
		CarDAO dao = new CarDAO();
		CarService service = new CarServiceImpl(dao);
		
		int page = 1;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
			
		}
		
		//int count = service.getCarAllCount();
		Paging paging = new Paging();
		paging.setCurrentPage(page);
		paging.setTotalcount(50);
		
		List<CarVO> list = service.getCarRec(page);
		
		request.setAttribute("carlist", list);
		request.setAttribute("paging", paging);
		
		String view = "/carList.jsp";
		
		getServletContext().getRequestDispatcher(view).forward(request, response);
		
	}

}
