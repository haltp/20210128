package co.micol.board.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;

public class insertCommand implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// 게시글 DB저장 메소드
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		vo.setbName(request.getParameter("bName"));
//		vo.setbDate(Date.valueOf(request.getParameter("bdate")));
		vo.setbTitle(request.getParameter("btitle"));
		vo.setbContent(request.getParameter("bcontent"));
		
		int n = dao.insert(vo);
		String viewPage = "boardInsert.do";
		if(n==0) {
			viewPage ="views/boardList/insertFail.jsp";
		}
		
		return "boardList.do";
	}

}
