package servlet;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.ImgDAO;
import service.ImgService;
import service.ImgServiceImpl;
import vo.ImgVO;

@WebServlet({ "/InsertImg1.do", "/InsertImg2.do", "/InsertImg3.do" })
@MultipartConfig(maxFileSize = 1024*1024*5)
public class ImgInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		LocalTime now = LocalTime.now();
		int time = now.getSecond();
		System.out.println("/InsertImg.do 이미지 업로드 요청 ");
	    response.setContentType("text/html;charset=utf-8");
	    request.setCharacterEncoding("UTF-8");
	    
	    String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf('/'));  
		
		if(action.equals("/InsertImg1.do")) {
			
			System.out.println("/InsertImg1.do 이미지 업로드 처리 ");
			
			ImgVO vo = new ImgVO();
			//차종 이미지와 이미지경로 
			vo.setImg_type(request.getParameter("car_type"));
	    
			ImgDAO dao = new ImgDAO();
			ImgService service = new ImgServiceImpl(dao);
	    
			String path = request.getRealPath("/upload/");
			System.out.println(path);
	    
			Collection<Part> parts = request.getParts();
			for(Part p :parts) {
				if(p.getContentType() != null) {
					String fileName = p.getSubmittedFileName();
					if(fileName != null && fileName.length() != 0) {
						p.write(path+fileName);
						//이미지 경로 저장 수정필요
						//vo.setImg_path1("./upload/"+fileName+String.valueOf(time));
						vo.setImg_path1("./upload/" + fileName);
					}
				}
			}
	    
			try {
				service.insertImg1(vo);
				request.getRequestDispatcher("./listImg.do").forward(request, response);
				
			} catch (Exception e) {
				request.setAttribute("exception", new Exception(" 다시 시도해주세요 "));
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}
		
		
		if(action.equals("/InsertImg2.do")) {
			
			System.out.println("/InsertImg2.do 이미지 업로드 요청 ");
			
			ImgVO vo = new ImgVO();
			//차종 이미지와 이미지경로 
			vo.setImg_type(request.getParameter("car_type"));
			
			ImgDAO dao = new ImgDAO();
			ImgService service = new ImgServiceImpl(dao);
			
			String path = request.getRealPath("/upload/");
			System.out.println(path);
			
			Collection<Part> parts = request.getParts();
			
			for(Part p :parts) {
				System.out.println("p ==>" + p);
				if(p.getContentType() != null) {
					String fileName = p.getSubmittedFileName();
					if(fileName != null && fileName.length() != 0) {
						p.write(path+fileName);
						//이미지 경로 저장 수정필요
						//vo.setImg_path2("./upload/"+fileName+String.valueOf(time));
						vo.setImg_path2("./upload/"+fileName);
					}
				}
			}
			
			try {
				service.insertImg2(vo);
				request.getRequestDispatcher("./listImg.do").forward(request, response);
				
			} catch (Exception e) {
				request.setAttribute("exception", new Exception(" 다시 시도해주세요 "));
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}
		
		
		if(action.equals("/InsertImg3.do")) {
			
			System.out.println("/InsertImg3.do 이미지 업로드 처리 ");
			
			ImgVO vo = new ImgVO();
			//차종 이미지와 이미지경로 
			vo.setImg_type(request.getParameter("car_type"));
			
			ImgDAO dao = new ImgDAO();
			ImgService service = new ImgServiceImpl(dao);
			
			String path = request.getRealPath("/upload/");
			System.out.println(path);
			
			Collection<Part> parts = request.getParts();
			
			for(Part p :parts) {
				System.out.println("p ==>" + p);
				if(p.getContentType() != null) {
					String fileName = p.getSubmittedFileName();
					if(fileName != null && fileName.length() != 0) {
						p.write(path+fileName);
						//이미지 경로 저장 수정필요
						//vo.setImg_path3("./upload/"+fileName+String.valueOf(time));
						vo.setImg_path3("./upload/"+fileName);
					}
				}
			}
			
			try {
				service.insertImg3(vo);
				request.getRequestDispatcher("./listImg.do").forward(request, response);
				
			} catch (Exception e) {
				request.setAttribute("exception", new Exception(" 다시 시도해주세요 "));
				request.getRequestDispatcher("/error.jsp").forward(request, response);
			}
		}
	    
	    
		
		
		
		
	    
	
	}

}
