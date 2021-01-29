package co.micol.board.web;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.board.common.Command;
import co.micol.board.dao.BoardDao;
import co.micol.board.vo.BoardVo;


public class BoardListCommand implements Command{
	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) {
		// boardForm.do 요청처리
		BoardDao dao = new BoardDao();
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		
		list = dao.selectList();
		request.setAttribute("list", list);
		return "views/boardList/boardList.jsp";
	}

}
