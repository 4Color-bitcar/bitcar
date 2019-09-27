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

@WebServlet("/hyundaiCar.do")
public class ListHyundaiCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		
		System.out.println("/hyundaiCar.do 요청 처리");
		
		CarDAO dao = new CarDAO();
		CarService service = new CarServiceImpl(dao);
		List<CarVO> list = service.getHyundaiCarRec();
		
		request.setAttribute("hyundaicarlist", list);
		
		String view = "/hyundai.jsp";
		
		getServletContext().getRequestDispatcher(view).forward(request, response);
		
	}

}
