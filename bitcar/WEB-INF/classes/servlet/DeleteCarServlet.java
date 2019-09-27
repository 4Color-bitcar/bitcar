package servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CarDAO;
import service.CarService;
import service.CarServiceImpl;

@WebServlet("/deleteCar.do")
public class DeleteCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8"); //한글안깨지기하기 위함.
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/deleteCar.do 요청 처리");
		
		String[] type = request.getParameterValues("type");
		String type1 = type[0].substring(0, type[0].lastIndexOf(','));
		String type2 = type[0].substring(type[0].lastIndexOf(',')+1);
		
		System.out.println(type[0].toString());
		System.out.println("type1 : " + type1);
		System.out.println("type2 : " + type2);
		
		//이미지 처리 수정 필요**
		//String img = request.getParameter("img");
		//System.out.println("img : " + img);
		//String fname = img.substring(img.lastIndexOf('/')+1);
		
		String fname = type2.substring(type2.lastIndexOf('/')+1);
		
		
		String path = request.getRealPath("/upload/");
		
		File f = new File(path + fname);
		System.out.println("path+fname : " + path + fname);
		System.out.println("path : " + path);
		System.out.println("fname : " + fname);
		if(f.exists()) {
			if(f.delete()) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		}
		
		CarDAO dao = new CarDAO();
		CarService service = new CarServiceImpl(dao);
		
		try {
			
//			for(String data : type) {
//				service.deleteCar(data);
//			}
			
			//하나만 삭제가능
			service.deleteCar(type1);
			
			response.sendRedirect("listCar.do");
			
		} catch (Exception e) {
			request.setAttribute("exception", e);
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	}

}
