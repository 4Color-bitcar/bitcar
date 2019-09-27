package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;
import service.UserService;
import service.UserServiceImpl;
import vo.UsersVO;

@WebServlet("/listUser.do")
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8"); 
		request.setCharacterEncoding("utf-8");
		
		System.out.println("/listuser.do 출력 요청");
		
		UsersDAO dao = new UsersDAO(); //유저dao객체생성
		UserService service = new UserServiceImpl(dao);
	   	List<UsersVO> list  = service.getAllUserInfo();
	   	
		request.setAttribute("userlist", list);
		
		String view = "/userList.jsp";
		
		getServletContext().getRequestDispatcher(view).forward(request, response);
	}

}
