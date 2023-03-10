package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import book.BookMainAction;
import dto.MemberDAO;

public class MypageDeleteAction implements Action{
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		String id = request.getParameter("id");

		MemberDAO mDao = MemberDAO.getInstance();
		mDao.deleteMember(id);
		
		new MemberLogoutAction().execute(request, response);

	}
}
