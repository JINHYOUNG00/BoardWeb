package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;

public class RemoveControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//bno, title, content 3개 파라미터
				System.out.println(req.getParameter("bno"));
				String boardNo = req.getParameter("bno");
				System.out.println(boardNo);
				BoardService svc = new BoardServiceImpl();
				
				
				if(svc.removeBoard(Integer.parseInt(boardNo))) {
					System.out.println("삭제성공");
					resp.sendRedirect("main.do");
				} else {
					System.out.println("삭제실패");
					resp.sendRedirect("main.do");
				}

	}

}
