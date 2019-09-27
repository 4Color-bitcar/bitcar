package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import service.UserService;
import service.UserServiceImpl;
import vo.UsersVO;

@WebServlet("/SignUp.do")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//회원 가입 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		UsersVO uvo = new UsersVO();
		
		uvo.setId(request.getParameter("id"));
		uvo.setPw(request.getParameter("pw"));
		uvo.setName(request.getParameter("name"));
		uvo.setPhone(request.getParameter("phone"));
		
		UsersDAO dao = new UsersDAO();
		UserService service = new UserServiceImpl(dao);
		
		int result = service.signUp(uvo);
		
		HttpSession session = request.getSession();
		
		if(result == 0 ) {
		    request.setAttribute("Message", "회원가입에 실패 ");
			
		}else {
			request.setAttribute("Message", "회원가입에 성공 ");
		    session.setAttribute("userid", uvo.getId());
		}
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	
	}//doPost

}
