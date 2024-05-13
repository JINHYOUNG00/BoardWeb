package com.yedam.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class AddFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "WEB-INF/board/addBoard.jsp";
		path = "board/addBoard.tiles";
//		String page = req.getParameter("page");

		BoardService boardService = new BoardServiceImpl();
//		List<BoardVO> list = boardService.boardList(Integer.parseInt(page));

		// jsp 페이지에 정보 전달
//		req.setAttribute("boardList", list);

		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);

	}

}
