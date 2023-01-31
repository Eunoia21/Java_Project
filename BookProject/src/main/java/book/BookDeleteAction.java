package book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BookDAO;

public class BookDeleteAction implements Action {

	@Override 
	public void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		
		int num = Integer.parseInt(request.getParameter("num"));
		//책의 num값을 기준으로 데이터를 삭제
		BookDAO bDao = BookDAO.getInstance();
		bDao.deleteBook(num);
		//deleteBook을 호출하면서 입력받은 num값의 데이터를 삭제
		
		new BookListAction().execute(request, response);
	}
}
