package book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dto.BookDAO;
import dto.BookVO;

public class BookUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "/book/bookUpdate.jsp";
		int num = Integer.parseInt(request.getParameter("num"));
		
		BookDAO bDao = BookDAO.getInstance();
		BookVO bVo = bDao.selectOneBookByNum(num);
		//selectOneBookByNum메서드에 입력받은 num값을 전달
		
		request.setAttribute("book", bVo);
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}
	
}
