package com.yedam.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardInfoControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "WEB-INF/board/board.jsp";
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		BoardServiceImpl svc = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo = svc.getBoard(Integer.parseInt(bno)); // 상세 조회
		svc.addViewCnt(Integer.parseInt(bno)); // 조회수 증가
		
		req.setAttribute("result", vo);
		req.setAttribute("page", page);

		RequestDispatcher rd = req.getRequestDispatcher(path);
		rd.forward(req, resp);
	}

}
