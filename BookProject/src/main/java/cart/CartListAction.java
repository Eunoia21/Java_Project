
package cart;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.Action;
import dto.CartDAO;
import dto.CartVO;

public class CartListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "/cart/cartList.jsp";
		
		CartDAO cDao = CartDAO.getInstance(); // CartDAO의 객체를 얻어오기 위해 getInstance()를 호출

		List<CartVO> cartlist = cDao.selectAllCarts(); // selectAllCarts 메소드를 호출하여 List<CartVO>객체에 저장
		request.setAttribute("cartlist", cartlist); // request객체의 속성에 데이터를 담아 jsp페이지로 보낸다

		RequestDispatcher dis = request.getRequestDispatcher(url); // cartlist.jsp로 포워딩
		dis.forward(request, response);
	
	}

}