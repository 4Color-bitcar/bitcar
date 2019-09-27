package servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.CarDAO;
import service.CarService;
import service.CarServiceImpl;
import vo.CarVO;

@WebServlet("/insertCar.do")
@MultipartConfig(maxFileSize = 1024*1024*5)  //img upload
public class InsertCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/insert.do 요청 처리");
		
		CarDAO dao = new CarDAO();
		CarService service = new CarServiceImpl(dao);
		
		CarVO vo = new CarVO();
		vo.setBrand(request.getParameter("brand"));
		vo.setType(request.getParameter("type"));
		vo.setYear(request.getParameter("year"));
		vo.setHistory(request.getParameter("history"));
		vo.setKm(request.getParameter("km"));
		vo.setPrice(request.getParameter("price"));
		
		String name = request.getParameter("type");
		
		String path = request.getRealPath("/upload/");
		
		Collection<Part> parts = request.getParts();
		for(Part p : parts) {
			if(p.getContentType()!=null) {
				String fileName = p.getSubmittedFileName();
				if(fileName!=null && fileName.length()!=0) {
					p.write(path + fileName);
					vo.setImg("./upload/" + fileName);
				}
			}
		}
		
		try {
			service.insertCar(vo);
			getServletContext().getRequestDispatcher("/insertImg.jsp?img_type="+name+",1").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("exception", new Exception("데이터를 확인 해주세요."));
			System.out.println(e);
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
	}

}
