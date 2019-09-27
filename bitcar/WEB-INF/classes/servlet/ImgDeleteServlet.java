package servlet;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImgDAO;
import service.ImgService;
import service.ImgServiceImpl;

@WebServlet("/DeleteImg.do")
public class ImgDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/DeleteImg.do 요청 처리");
		
		String[] type = request.getParameterValues("type");
		String[] img = type[0].split(",");
		
		System.out.println(type[0].toString());
		
		
	    String path = request.getRealPath("/upload/");
	    
	    for(int i=1 ; i<img.length ; i++) {
	    	
	    	String fname = img[i].substring(img[i].lastIndexOf('/')+1);
	    	File f = new File(path+fname);
	    	
	    	if(f.exists()) {
	    		if(f.delete()) {
	    			System.out.println("삭제 성공");
	    		} else {
	    			System.out.println("삭제 실패");
	    		}
	    	}
	    }
	
	    ImgDAO dao = new ImgDAO();
	    ImgService service = new ImgServiceImpl(dao);
	    
	    try {
	    	service.deleteImg(img[0]);
	    	response.sendRedirect("./listCar.do");
	    	
	    }catch (Exception e) {
	    	request.setAttribute("exception", e);
	    	request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
	
	}

}
