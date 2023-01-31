package book;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BookDAO;
import dto.BookVO;

public class BookListAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
	     
		String url = "/book/bookList.jsp";
	      
	      BookDAO bDao = BookDAO.getInstance();
	      
	      List<BookVO> booklist = bDao.selectAllBooks();
	     //selectAllBooks메서드를 호출하여 List<BookVO> 객체에 저장
	      request.setAttribute("booklist", booklist);
	      //"booklist"에 booklist값을 저장
	      
	      RequestDispatcher dis = request.getRequestDispatcher(url);
	      dis.forward(request, response);
	   }

	
}
