package book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	public BookServlet() {
		
		super();
	}
	//요청을 받아서 요청에 해당하는 Model과 View를 호출하는 역할
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list?choice=title&input=a
		
		String command = request.getParameter("command");
		System.out.println("BookServlet에서 요청을 받음을 확인: "+command);
		
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getAction(command);
		//command요청 파라미터 값을 af객체의 getAction() 메서드에 전달
		
		
		if(action != null) {
			action.execute(request, response); //null이 아닐 경우에만 execute()메서드가 호출됨
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글 깨짐 방지
		
		doGet(request,response);
	}

}
