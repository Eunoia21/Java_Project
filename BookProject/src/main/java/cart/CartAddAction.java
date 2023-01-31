package cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.Action;
import dto.CartDAO;
import dto.CartVO;
import member.MemberLogoutAction;

public class CartAddAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		session.getAttribute("member");
		
		
		CartVO cVo = new CartVO();
		
		cVo.setNum(Integer.parseInt(request.getParameter("num")));
		cVo.setId(request.getParameter("id"));
		cVo.setPrice(Integer.parseInt(request.getParameter("price")));
		cVo.setTitle(request.getParameter("title"));
		cVo.setPictureurl(request.getParameter("pictureurl"));
		System.out.println("cVo: "+cVo);
		
		CartDAO cDao = CartDAO.getInstance();
		cDao.insertCart(cVo);
		
		response.sendRedirect("BookServlet?command=cart_check_form");
		
		
	}
}
