package book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BookDAO;
import dto.BookVO;

public class BookRegisterAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		BookVO bVo = new BookVO();
		//bVo 객체 생성
		
		bVo.setCategory(request.getParameter("category"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setPrice(Integer.parseInt(request.getParameter("price")));
		bVo.setSummary(request.getParameter("summary"));
		bVo.setAuthor(request.getParameter("author"));
		bVo.setPub(request.getParameter("pub"));
		bVo.setGrade(request.getParameter("grade"));
		bVo.setPictureurl(request.getParameter("pictureurl"));
		//getParameter로 입력받은 값들을 bVo에 저장
		
		BookDAO eDao = BookDAO.getInstance();
		eDao.insertBook(bVo);
		//insertBook메서드를 호출해서 입력받은 bVo값을 전달
		
		response.sendRedirect("BookServlet?command=book_list");
	}
}