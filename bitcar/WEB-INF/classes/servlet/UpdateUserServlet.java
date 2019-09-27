package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;
import service.UserService;
import service.UserServiceImpl;
import vo.UsersVO;

@WebServlet("/UpdateUser.do")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/UpdateUser.do 요청 처리");
		
		//변경하고자 하는 비번이 들어오면 
		String updatePw = request.getParameter("pw2");
		String id = request.getParameter("id");
		
		System.out.println("pw2 : " + request.getParameter("pw2"));
		System.out.println("id : " + request.getParameter("id"));
		System.out.println("---------------");
		
	    //vo 객체에 저장하고
		UsersVO vo = new UsersVO();
		vo.setPw(updatePw);
		vo.setId(id);
		
		UsersDAO dao = new UsersDAO();
		UserService service = new UserServiceImpl(dao);
		
		System.out.println(vo);
		System.out.println(vo.getPw());
		System.out.println(vo.getId());
		
		try {
			service.updateUser(vo.getPw(),vo.getId());
			getServletContext().getRequestDispatcher("/company.jsp").forward(request, response);
		} catch (Exception e) {
			request.setAttribute("exception", new Exception("데이터를 확인 해주세요."));
			System.out.println(e);
			getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
		}
		
		
		
	
	}

}
