package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");
		
		BoardServiceImpl svc = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);
		
		if(svc.addBoard(vo)) {
			System.out.println("등록성공");
			resp.sendRedirect("main.do");
		} else {
			System.out.println("등록실패");
			resp.sendRedirect("addForm.do");
		}
	}

}
