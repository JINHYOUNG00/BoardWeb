package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//bno, title, content 3개 파라미터
		String boardNo = req.getParameter("bno");
		String title= req.getParameter("title");
		String content = req.getParameter("content");
		String page = req.getParameter("page");
	
		
		BoardServiceImpl svc = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setBoardNo(Integer.parseInt(boardNo));
		
		if(svc.modifyBoard(vo)) {
			System.out.println("수정성공");
			resp.sendRedirect("main.do?page=" + page);
		} else {
			System.out.println("수정실패");
			resp.sendRedirect("modBoardForm.do");
		}
		
		
	}

}
