package com.yedam.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class RemoveFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "WEB-INF/board/removeBoard.jsp";
		path = "board/removeBoard.tiles";
		String bno = req.getParameter("bno");
		BoardService svc = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo = svc.getBoard(Integer.parseInt(bno));
		
		req.setAttribute("result", vo);
		
		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}

}
