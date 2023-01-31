package member;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.MemberDAO;


public class IdCheckAction implements Action{

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		MemberDAO mDao = MemberDAO.getInstance();
		
		int result = mDao.confirmID(id);

		request.setAttribute("id", id);
		request.setAttribute("result", result);

		request.getRequestDispatcher("/member/idCheck.jsp").forward(request, response);
		new IdCheckAction().execute(request, response);
		
}
	}