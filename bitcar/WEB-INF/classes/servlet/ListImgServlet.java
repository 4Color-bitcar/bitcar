package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImgDAO;
import service.ImgService;
import service.ImgServiceImpl;
import vo.ImgVO;

@WebServlet("/listImg.do")
public class ListImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8"); 
		
		System.out.println("/listImg.do 요청 처리");
		
		ImgDAO dao = new ImgDAO();
		ImgService service = new ImgServiceImpl(dao);
		List<ImgVO> list = service.getImgRec();
		
		request.setAttribute("imglist", list);
		
		String view = "/imgList.jsp";
		
		getServletContext().getRequestDispatcher(view).forward(request, response);
		
	}

}
