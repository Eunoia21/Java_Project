package cart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.CartDAO;
import dto.CartVO;

public class CartCheckAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		CartVO cVo = new CartVO();
		
//		cVo.setCartnum(Integer.parseInt(request.getParameter("cartnum")));
//		cVo.setId(request.getParameter("id"));
//		cVo.setNum(Integer.parseInt(request.getParameter("num")));
//		cVo.setTitle(request.getParameter("title"));
//		cVo.setPrice(Integer.parseInt(request.getParameter("price")));
//		cVo.setPictureurl(request.getParameter("pictureurl"));
		
		CartDAO cDao = CartDAO.getInstance();
		cDao.insertCart(cVo);
		String url = "/cart/cartCheck.jsp";
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}
}
