package book;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.BookDAO;
import dto.BookVO;

public class BookSearchAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/book/bookSearch.jsp";
		String searchCategory = request.getParameter("searchCategory");
		String keyWord = request.getParameter("keyWord");
		
		HttpSession session = request.getSession();
		session.setAttribute("keyWord", keyWord);
		
		BookDAO bDao = BookDAO.getInstance();
		
		int count = bDao.bookCount(searchCategory, keyWord);
		request.setAttribute("count", count);
		
		List<BookVO> searchResult = bDao.searchBook(searchCategory, keyWord);
		request.setAttribute("searchResult", searchResult);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}