package co.micol.board.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.web.BoardDelete;
import co.micol.board.web.BoardInsertCommand;
import co.micol.board.web.BoardListCommand;
import co.micol.board.web.BoardView;
import co.micol.board.web.MainCommand;
import co.micol.board.web.insertCommand;


@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<String, Command>();
    
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/boardList.do", new BoardListCommand());//게시글 목록
		map.put("/boardForm.do", new BoardInsertCommand());//글 작성 폼
		map.put("/boardInsert.do", new insertCommand());//글 등록
		map.put("/boardView.do", new BoardView()); //글 상세보기
		map.put("/boardDelete.do", new BoardDelete()); //글 삭제
//		map.put("/boardEditForm.do", new BoardEditForm()); //글 수정
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contexPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contexPath.length());  //실제 요청

		Command command = map.get(path);	//Command 인터페이스, 요청한 것을 처리하는 command를 찾아준다
		String viewPage = command.excute(request, response); //처리한 후 결과를 돌려줄 page 값을 받음
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
