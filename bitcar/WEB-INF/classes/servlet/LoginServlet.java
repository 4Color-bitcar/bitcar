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

@WebServlet({ "/Login.do", "/logout.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = request.getSession();
		if(session != null) {
			session.invalidate();
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
		
	}//doGet

	//회원 가입 후 첫 로그인 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		System.out.println("Login.do 처리요청");
		
		String id = request.getParameter("id");					
		String pw = request.getParameter("pw");		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
							
						
		UsersDAO dao = new UsersDAO();					
		UserService service = new UserServiceImpl(dao);					
		UsersVO loginCheck = service.login(id,pw);					
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", loginCheck);	
							
		
		if(loginCheck.getId()==null) {	
			
			request.setAttribute("msg", "아이디를 확인해 주세요 ");				
			request.getRequestDispatcher("login.jsp").forward(request, response);
			session.invalidate(); //로그인 실패시 세션 파괴
			
		} else if(!(loginCheck.getPw().equals(pw)) && loginCheck.getId().equals(id)) {
			
			request.setAttribute("msg", "비밀번호를 확인해 주세요 ");				
			request.getRequestDispatcher("login.jsp").forward(request, response);
			session.invalidate(); //로그인 실패시 세션 파괴
			
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);	
		}
		
	}//doPost

}





