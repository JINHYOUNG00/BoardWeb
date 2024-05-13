package com.yedam.web;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//bno, title, content 3개 파라미터
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html; charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		String boardNo = req.getParameter("bno");
		String title= req.getParameter("title");
		String content = req.getParameter("content");
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		String encodeKw = URLEncoder.encode(kw, "UTF-8"); // 한글 인코딩처리
		
		System.out.println(encodeKw);
	
		
		BoardService svc = new BoardServiceImpl();
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setBoardNo(Integer.parseInt(boardNo));
		
		if(svc.modifyBoard(vo)) {
			System.out.println("수정성공");
			resp.sendRedirect("main.do?page=" + page + "&searchCondition=" + sc + "&keyword=" + encodeKw);
			
		} else {
			System.out.println("수정실패");
			resp.sendRedirect("modBoardForm.do");
		}
		
		
	}

}
