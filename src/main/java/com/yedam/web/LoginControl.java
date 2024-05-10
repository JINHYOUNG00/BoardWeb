package com.yedam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// id, pw 파라미터
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		BoardService boardService = new BoardServiceImpl();
		MemberVO member = boardService.login(id, pw);
		
		if(member != null) {
			// 로그인 성공 시 세션 정보에 로그인 아이디를 담아넣음
			HttpSession session = req.getSession();
			session.setAttribute("logId", member.getUserId());
			resp.sendRedirect("main.do");
		} else {
			resp.sendRedirect("loginForm.do");
		}
	}

}
