package book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BookDAO;
import dto.BookVO;


public class BookDetailAction implements Action {
   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   String url = "/book/bookDetail.jsp";
      int num = Integer.parseInt(request.getParameter("num"));
      //책의 num값을 기준으로 책의 상세정보를 검색
      
      BookDAO bDao = BookDAO.getInstance();
      BookVO bVo = bDao.selectOneBookByNum(num);
      
      request.setAttribute("book", bVo);
      //"book"에 bVo의 정보를 담는다.
      
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
      dispatcher.forward(request, response);
   }
}