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

@WebServlet("/IddupliCheck")
public class IddupliCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String user_id = request.getParameter("id");
		
		UsersDAO dao = new UsersDAO();
		UserService service = new UserServiceImpl(dao);
		
		boolean iddupliCheck = service.idCheck(user_id);
		
		//결과값을 jsp로전달 해준다.
		//이 결과값을 가지고 자바스크립트로 처리 해주면 된다. 
		request.setAttribute("result", iddupliCheck);
		request.setAttribute("user_id", user_id);
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	
	}//doPost

}
