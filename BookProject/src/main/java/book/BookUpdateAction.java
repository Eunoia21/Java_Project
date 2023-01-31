package book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BookDAO;
import dto.BookVO;

public class BookUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		BookVO bVo = new BookVO();
		//bVo 객체 생성
		
		bVo.setNum(Integer.parseInt(request.getParameter("num")));
		bVo.setCategory(request.getParameter("category"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setPrice(Integer.parseInt(request.getParameter("price")));
		bVo.setSummary(request.getParameter("summary"));
		bVo.setAuthor(request.getParameter("author"));
		bVo.setPub(request.getParameter("pub"));
		bVo.setGrade(request.getParameter("grade"));
		bVo.setPictureurl(request.getParameter("pictureurl"));
		//bVo에 getParameter로 입력받은 값을 저장
		
		BookDAO bDao = BookDAO.getInstance();
		bDao.updateBook(bVo);
		//updateBook메서드에 bVo값을 전달
		
		new BookListAction().execute(request,response);
	}
}
